package com.company.BrianLoraU1Capstone.service;

import com.company.BrianLoraU1Capstone.dao.*;
import com.company.BrianLoraU1Capstone.model.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;

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
    public void saveInvoice() {
    }

    @Test
    public void findInvoiceById() {
    }

    @Test
    public void updateInvoice() {
    }

    @Test
    public void removeInvoice() {
    }

    private void setInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
    }


}