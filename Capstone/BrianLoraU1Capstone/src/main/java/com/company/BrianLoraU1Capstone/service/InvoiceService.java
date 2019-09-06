package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.*;

import com.company.BrianLoraU1Capstone.model.*;
import com.company.BrianLoraU1Capstone.viewmodel.InvoiceViewModel;
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
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());

        // calculate totals before storing
        invoice.setSubTotal(calculateSubTotal(invoice.getItemId(), invoice.getQuantity(), invoice.getItemType()));
        invoice.setTax(calculateTax(invoice.getSubTotal(), invoice.getState()));
        invoice.setProcessingFee(caclculateProcessingFee(invoice.getState(), invoice.getQuantity()));
        invoice.setTotal(calculateTotal(invoice.getSubTotal(), invoice.getTax(), invoice.getProcessingFee()));

        invoice = invoiceDao.addInvoice(invoice);

        // update InvoiceViewModel to reflect new values
        invoiceViewModel.setId(invoice.getInvoiceId());
        invoiceViewModel.setSubTotal(invoice.getSubTotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
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

    private BigDecimal caclculateProcessingFee(String itemType, int itemQuantity) {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(itemType);
        BigDecimal fees = processingFee.getFee();
        if (itemQuantity >= 10) {
            fees.add(new BigDecimal("15.49"));
        }
        return fees;
    }

    private BigDecimal calculateSubTotal(int id, int quantity, String itemType) {
        BigDecimal subtotal;
        BigDecimal price = new BigDecimal("0.00");

        switch (itemType.toLowerCase()) {
            case "console":
                Console console = consoleDao.getConsoleById(id);
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
        subtotal = price.multiply(new BigDecimal(quantity));
        return subtotal;
    }

    private BigDecimal calculateTotal(BigDecimal subTotal, BigDecimal taxRate, BigDecimal processingFee) {
        BigDecimal postTax = subTotal.multiply(taxRate).add(subTotal);
        return postTax.add(processingFee);
    }

    // HELPER METHOD TO CREATE A NEW INVOICE VIEW MODEL
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(invoice.getInvoiceId());
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoice.setCity(invoice.getCity());
        invoice.setState(invoice.getState());
        invoice.setZipCode(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        invoiceViewModel.setSubTotal(invoice.getSubTotal());
        invoiceViewModel.setTax(invoice.getTax());
        invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
        invoiceViewModel.setTotal(invoice.getTotal());

        return invoiceViewModel;
    }
}
