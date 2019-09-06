package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.*;

import com.company.BrianLoraU1Capstone.model.Invoice;
import com.company.BrianLoraU1Capstone.model.ProcessingFee;
import com.company.BrianLoraU1Capstone.model.SalesTaxRate;
import com.company.BrianLoraU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class InvoiceService {
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Autowired
    public InvoiceService(InvoiceDao invoiceDao, SalesTaxRateDao salesTaxRateDao, ProcessingFeeDao processingFeeDao) {
        this.invoiceDao = invoiceDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

    // INVOICE TOTAL METHODS
    private BigDecimal calculateTax(BigDecimal subtotal, String state) {
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate(state);
        BigDecimal tax = subtotal.multiply(salesTaxRate.getRate());
        return tax;
    }

    private BigDecimal getProcessingFee(String itemType, int itemQuantity) {
        ProcessingFee processingFee = processingFeeDao.getProcessingFee(itemType);
        BigDecimal fees = processingFee.getFee();
        if (itemQuantity >= 10) {
            fees.add(new BigDecimal("15.49"));
        }
        return fees;
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
        invoice.setSubTotal(invoiceViewModel.getSubTotal());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setProcessingFee(invoiceViewModel.getProcessingFee());
        invoice.setTotal(invoiceViewModel.getTotal());

        invoice = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setId(invoice.getInvoiceId());

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
