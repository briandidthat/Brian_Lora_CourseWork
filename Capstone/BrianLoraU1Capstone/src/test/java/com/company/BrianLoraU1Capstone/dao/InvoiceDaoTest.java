package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {
    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        for (Invoice i : invoices) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }
    }

    @Test
    public void addGetDeleteInvoice() {
        // add
        Invoice invoice = new Invoice();
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
        invoice = invoiceDao.addInvoice(invoice);
        // get
        Invoice invoice1 = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        assertEquals(invoice1, invoice);
        // delete
        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice1 = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        // test for null value to verify deletion
        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
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
        invoice = invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Marcus Arelius");
        invoice.setStreet("1122 Broadway");
        invoice.setCity("Los Angeles");
        invoice.setState("CA");
        invoice.setZipCode("90201");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("599.99"));
        invoice.setQuantity(4);
        invoice.setSubTotal(new BigDecimal("11.98"));
        invoice.setTax(new BigDecimal("17.78"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("100.00"));
        invoiceDao.addInvoice(invoice);

        List<Invoice> invoices = invoiceDao.getAllInvoices();
        assertEquals(2, invoices.size());
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
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
        invoice = invoiceDao.addInvoice(invoice);
        // set new values and update in DB
        invoice.setTotal(new BigDecimal("200.00"));
        invoice.setQuantity(3);
        invoiceDao.addInvoice(invoice);
        // get and compare
        Invoice invoice1 = invoiceDao.getInvoiceById(invoice.getInvoiceId());
        assertEquals(invoice1, invoice);
    }

}