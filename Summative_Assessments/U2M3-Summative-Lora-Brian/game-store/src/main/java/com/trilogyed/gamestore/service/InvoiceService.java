package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.*;
import com.trilogyed.gamestore.exception.NotFoundException;
import com.trilogyed.gamestore.model.*;
import com.trilogyed.gamestore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * INVOICE SERVICE:
 * Purpose: To perform all CRUD operations and necessary calculations needed for Invoices.
 * Private Methods:
 * calculateTax(), calculateTotal(), calculateProcessingFee(), calculateSubtotal(), getItemPrice(), validateInventory()
 * Public Methods:
 * saveInvoice(), findInvoiceById(), findAllInvoices(), updateInvoice(), removeInvoice()
 */

@Component
public class InvoiceService {
    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public InvoiceService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, TShirtDao tShirtDao,
                          ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;

    }

    public InvoiceViewModel saveInvoice(Invoice invoice) {
        // VALIDATE INVENTORY BEFORE PERFORMING ANY VALUES
        if (validateInventory(invoice.getItemId(), invoice.getQuantity(), invoice.getItemType())) {
            // CALCULATE VALUES
            BigDecimal unitPrice = getItemPrice(invoice.getItemId(), invoice.getItemType());
            BigDecimal subTotal = calculateSubTotal(invoice.getQuantity(), unitPrice);
            BigDecimal tax = calculateTax(subTotal, invoice.getState());
            BigDecimal processingFee = calculateProcessingFee(invoice.getItemType(), invoice.getQuantity());
            BigDecimal total = calculateTotal(subTotal, tax, processingFee);
            // STORE VALUES
            invoice.setUnitPrice(unitPrice);
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

    public void updateInvoice(Invoice invoice) {
        invoiceDao.updateInvoice(invoice);
    }

    public void removeInvoice(int id) {
        invoiceDao.deleteInvoice(id);
    }

    // INVOICE CALCULATION METHODS
    // ======================================================================================================
    private BigDecimal calculateTax(BigDecimal subtotal, String state) {
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate(state);
        return subtotal.multiply(salesTaxRate.getRate());
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

    // calculate subtotal by multiplying the quantity x price
    private BigDecimal calculateSubTotal(int quantity, BigDecimal price) {
        BigDecimal subTotal = price.multiply(new BigDecimal(quantity));
        return subTotal;
    }

    // calculate the total based on the taxRate and subtotal
    private BigDecimal calculateTotal(BigDecimal subTotal, BigDecimal taxRate, BigDecimal processingFee) {
        BigDecimal postTax = subTotal.add(taxRate);
        return postTax.add(processingFee);
    }

    // VALIDATE INVENTORY AND UPDATE
    private boolean validateInventory(int id, int quantity, String itemType) {
        int updatedValue;
        String fixedItem = itemType.toLowerCase();
        boolean inStock = false;

        if (fixedItem.equals("consoles")) {
            Console console = consoleDao.getConsoleById(id);
            if (console.getQuantity() >= quantity) {
                inStock = true;
                updatedValue = console.getQuantity() - quantity;
                consoleDao.updateConsoleInventory(id, updatedValue);
            }
        } else if (fixedItem.equals("tshirts")) {
            TShirt tShirt = tShirtDao.getTShirtById(id);
            if (tShirt.getQuantity() >= quantity) {
                inStock = true;
                updatedValue = tShirt.getQuantity() - quantity;
                tShirtDao.updateTShirtInventory(id, updatedValue);
            }
        } else if (fixedItem.equals("games")) {
            Game game = gameDao.getGameById(id);
            if (game.getQuantity() >= quantity) {
                inStock = true;
                updatedValue = game.getQuantity() - quantity;
                gameDao.updateGameInventory(id, updatedValue);
            }
        } else {
            throw new NotFoundException("Sorry, we do not have that item in stock. " +
                    "Please select Games,Consoles or Tshirts.");
        }
        return inStock;
    }

    // GET THE ITEM PRICE BASED ON THE ID AND ITEM-TYPE
    private BigDecimal getItemPrice(int id, String itemType) {
        BigDecimal price;
        String fixedItemType = itemType.toLowerCase();

        switch (fixedItemType) {
            case "consoles":
                Console console = consoleDao.getConsoleById(id);
                price = console.getPrice();
                break;
            case "tshirts":
                TShirt tShirt = tShirtDao.getTShirtById(id);
                price = tShirt.getPrice();
                break;
            case "games":
                Game game = gameDao.getGameById(id);
                price = game.getPrice();
                break;
            default:
                throw new NotFoundException("Sorry, we can not find any item type that matches that query.");
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
