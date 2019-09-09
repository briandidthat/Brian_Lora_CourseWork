package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.*;

import com.company.BrianLoraU1Capstone.exception.NotFoundException;
import com.company.BrianLoraU1Capstone.model.*;
import com.company.BrianLoraU1Capstone.viewmodel.InvoiceViewModel;
import com.company.BrianLoraU1Capstone.viewmodel.OrderViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class InvoiceService {
    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    TShirtDao tShirtDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public InvoiceService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, TShirtDao tShirtDao,
                          SalesTaxRateDao salesTaxRateDao, ProcessingFeeDao processingFeeDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(OrderViewModel orderViewModel) {
        // validate inventory before performing any calculations
        if (validateInventory(orderViewModel.getItemId(), orderViewModel.getQuantity(), orderViewModel.getItemType())) {
            Invoice invoice = new Invoice();
            invoice.setName(orderViewModel.getName());
            invoice.setStreet(orderViewModel.getStreet());
            invoice.setCity(orderViewModel.getCity());
            invoice.setState(orderViewModel.getState());
            invoice.setZipCode(orderViewModel.getZip());
            invoice.setItemType(orderViewModel.getItemType());
            invoice.setItemId(orderViewModel.getItemId());
            invoice.setUnitPrice(getItemPrice(orderViewModel.getItemId(), orderViewModel.getItemType()));
            invoice.setQuantity(orderViewModel.getQuantity());

            // calculate values
            BigDecimal subTotal = calculateSubTotal(orderViewModel.getItemId(), orderViewModel.getQuantity(),
                    orderViewModel.getItemType());
            BigDecimal tax = calculateTax(subTotal, orderViewModel.getState());
            BigDecimal processingFee = calculateProcessingFee(orderViewModel.getItemType(), orderViewModel.getQuantity());
            BigDecimal total = calculateTotal(subTotal, tax, processingFee);

            // STORE VALUES
            invoice.setSubTotal(subTotal);
            invoice.setTax(tax);
            invoice.setProcessingFee(processingFee);
            invoice.setTotal(total);

            invoice = invoiceDao.addInvoice(invoice);

            return buildInvoiceViewModel(invoice);

        } else {
            throw new IllegalArgumentException("Sorry we dont have enough in stock for that order.");
        }
    }

    public InvoiceViewModel findInvoiceById(int id) {
        Invoice invoice = invoiceDao.getInvoiceById(id);
        if (invoice == null) {
            return null;
        } else {
            return buildInvoiceViewModel(invoice);
        }
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoiceViewModel.getId());
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubTotal(invoiceViewModel.getSubTotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());

        invoiceDao.updateInvoice(invoice);
    }

    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    // INVOICE CALCULATION METHODS
    private BigDecimal calculateTax(BigDecimal subtotal, String state) {
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate(state);
        BigDecimal tax = subtotal.multiply(salesTaxRate.getRate());
        return tax;
    }
    // calculate the processing fee based on itemType
    private BigDecimal calculateProcessingFee(String itemType, int itemQuantity) {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(itemType);
        BigDecimal fees = processingFee.getFee();
        if (itemQuantity >= 10) {
            fees = fees.add(new BigDecimal("15.49"));
        }
        return fees;
    }
    // calculate total by checking the itemType and returning
    private BigDecimal calculateSubTotal(int id, int quantity, String itemType) {
        BigDecimal subtotal;
        BigDecimal price = getItemPrice(id, itemType);
        subtotal = price.multiply(new BigDecimal(quantity));

        return subtotal;
    }
    // calculate the total based on the taxRate and subtotal
    private BigDecimal calculateTotal(BigDecimal subTotal, BigDecimal taxRate, BigDecimal processingFee) {
        BigDecimal postTax = subTotal.multiply(taxRate).add(subTotal);
        return postTax.add(processingFee);
    }
    // VALIDATE INVENTORY AND UPDATE
    private boolean validateInventory(int id, int quantity, String itemType) {
        boolean inStock = false;

        if (itemType.equalsIgnoreCase("consoles")) {
            Console console = consoleDao.getConsoleById(id);
            if (console.getQuantity() >= quantity) {
                inStock = true;
                consoleDao.updateConsoleInventory(id, quantity);
            }
        } else if (itemType.equalsIgnoreCase("tshirts")) {
            TShirt tShirt = tShirtDao.getTShirtById(id);
            if (tShirt.getQuantity() >= quantity) {
                inStock = true;
                tShirtDao.updateTShirtInventory(id, quantity);
            }
        } else if (itemType.equalsIgnoreCase("games")) {
            Game game = gameDao.getGameById(id);
            if (game.getQuantity() >= quantity) {
                inStock = true;
                gameDao.updateGameInventory(id, quantity);
            }
        } else {
            throw new NotFoundException("Sorry, we do not have that item in stock. " +
                    "Please select Games,Consoles or Tshirts.");
        }
        return inStock;
    }
    // get the item price based on the itemType
    private BigDecimal getItemPrice(int id, String itemType) {
        BigDecimal price = new BigDecimal("00.00");
        String fixedItemType = itemType.toLowerCase();

        switch (fixedItemType) {
            case "console":
                Console console = consoleDao.getConsoleById(2);
                price = console.getPrice();
                break;
            case "tshirt":
                TShirt tShirt = tShirtDao.getTShirtById(id);
                price = tShirt.getPrice();
                break;
            case "game":
                Game game = gameDao.getGameById(id);
                price = game.getPrice();
                break;
            default:
                break;
        }
        return price;
    }

    // HELPER METHOD TO CREATE A NEW INVOICE VIEW MODEL
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZipCode(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubTotal(invoice.getSubTotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }
}
