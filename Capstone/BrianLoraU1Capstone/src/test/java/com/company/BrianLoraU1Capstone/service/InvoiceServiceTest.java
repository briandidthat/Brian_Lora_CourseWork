package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.*;
import com.company.BrianLoraU1Capstone.model.Invoice;
import com.company.BrianLoraU1Capstone.model.SalesTaxRate;
import com.company.BrianLoraU1Capstone.viewmodel.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceServiceTest {
    InvoiceService invoiceService;
    GameDao gameDao;
    TShirtDao tShirtDao;
    ConsoleDao consoleDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        setInvoiceDaoMock();
        invoiceService = new InvoiceService(consoleDao, gameDao, invoiceDao, tShirtDao,
                salesTaxRateDao, processingFeeDao);

    }

    @Test
    public void saveFindInvoiceByIdRemove() {
        OrderViewModel order = new OrderViewModel();
        order.setName("Brian Lora");
        order.setStreet("502 Broadway");
        order.setCity("Los Angeles");
        order.setState("NY");
        order.setZip("90201");
        order.setItemType("consoles");
        order.setItemId(28);
        order.setQuantity(2);

        InvoiceViewModel invoice = invoiceService.saveInvoice(order);
        InvoiceViewModel invoiceViewModel = invoiceService.findInvoiceById(invoice.getId());

        assertEquals(invoiceViewModel, invoice);
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void findAllInvoices() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(1, invoiceList.size());
    }

    private void setInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Brian Lora");
        invoice.setStreet("502 Broadway");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipCode("90201");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("599.99"));
        invoice.setQuantity(2);
        invoice.setSubTotal(new BigDecimal("11.98"));
        invoice.setTax(new BigDecimal("17.78"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("100.00"));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Brian Lora");
        invoice1.setStreet("502 Broadway");
        invoice1.setCity("Los Angeles");
        invoice1.setState("CA");
        invoice1.setZipCode("90201");
        invoice1.setItemType("Console");
        invoice1.setItemId(1);
        invoice1.setUnitPrice(new BigDecimal("599.99"));
        invoice1.setQuantity(2);
        invoice1.setSubTotal(new BigDecimal("11.98"));
        invoice1.setTax(new BigDecimal("17.78"));
        invoice1.setProcessingFee(new BigDecimal("14.99"));
        invoice1.setTotal(new BigDecimal("100.00"));

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).getInvoiceById(1);
        doReturn(iList).when(invoiceDao).getAllInvoices();
    }

}