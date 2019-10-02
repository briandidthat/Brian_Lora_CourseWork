package com.trilogyed.gamestore.service;

import com.trilogyed.gamestore.dao.*;
import com.trilogyed.gamestore.model.Console;
import com.trilogyed.gamestore.model.Invoice;
import com.trilogyed.gamestore.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {
    GameDao gameDao;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    InvoiceDao invoiceDao;
    SalesTaxRateDao salesTaxRateDao;
    ProcessingFeeDao processingFeeDao;
    InvoiceService invoiceService;


    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTShirtDaoMock();
        setUpSalesTaxRateDao();
        setUpProcessingFeeDaoMock();
        invoiceService = new InvoiceService(consoleDao,gameDao,invoiceDao,tShirtDao,salesTaxRateDao,processingFeeDao);
    }

    @Test
    public void saveFindInvoice() {
        Invoice invoice = new Invoice();

    }

    // SETUP METHODS
    private void setUpInvoiceDaoMock() {
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
        invoice.setQuantity(2);
        invoice.setUnitPrice(BigDecimal.valueOf(30.00));
        invoice.setSubTotal(BigDecimal.valueOf(60.00));
        invoice.setTax(BigDecimal.valueOf(17.78));
        invoice.setProcessingFee(BigDecimal.valueOf(14.99));
        invoice.setTotal(BigDecimal.valueOf(100.00));

        Invoice invoice1 = new Invoice();
        invoice1.setName("Brian Lora");
        invoice1.setStreet("502 Broadway");
        invoice1.setCity("Los Angeles");
        invoice1.setState("CA");
        invoice1.setZipCode("90201");
        invoice1.setItemType("Console");
        invoice1.setItemId(1);
        invoice1.setQuantity(2);
        invoice1.setUnitPrice(BigDecimal.valueOf(30.00));
        invoice1.setSubTotal(BigDecimal.valueOf(60.00));
        invoice1.setTax(BigDecimal.valueOf(17.78));
        invoice1.setProcessingFee(BigDecimal.valueOf(14.99));
        invoice1.setTotal(BigDecimal.valueOf(100.00));

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        doReturn(invoices).when(invoiceDao).getAllInvoices();
        doReturn(invoice).when(invoiceDao).getInvoiceById(1);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("i7");
        console.setPrice(BigDecimal.valueOf(30.00));
        console.setQuantity(10);

        Console console1 = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2TB");
        console.setProcessor("i7");
        console.setPrice(BigDecimal.valueOf(30.00));
        console.setQuantity(10);

        List<Console> consoles = new ArrayList<>();
        consoles.add(console);

        doReturn(console).when(consoleDao).addConsole(console);
        doReturn(consoles).when(consoleDao).getAllConsoles();
        doReturn(console).when(consoleDao).getConsoleById(1);
    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
    }

    private void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
    }

    private void setUpSalesTaxRateDao() {
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
    }

    private void setUpProcessingFeeDaoMock() {
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
    }
}