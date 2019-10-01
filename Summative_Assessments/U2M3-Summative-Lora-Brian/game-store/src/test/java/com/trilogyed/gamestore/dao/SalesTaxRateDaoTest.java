package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.SalesTaxRate;
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
public class SalesTaxRateDaoTest {
    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
        List<SalesTaxRate> taxRates = salesTaxRateDao.getAllSalesTaxRates();
        for(SalesTaxRate s : taxRates) {
            salesTaxRateDao.deleteSalesTaxRate(s.getState());
        }
    }

    @Test
    public void addGetDeleteSalesTaxRate() {
        // add
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.05"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);
        // get
        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate1, salesTaxRate);
        // delete
        salesTaxRateDao.deleteSalesTaxRate(salesTaxRate.getState());
        salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertNull(salesTaxRate1);
    }

    @Test
    public void updateSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.05"));
        salesTaxRate = salesTaxRateDao.addSalesTaxRate(salesTaxRate);
        // set values and store in DB
        salesTaxRate.setRate(new BigDecimal("0.07"));
        salesTaxRateDao.updateSalesTaxRate(salesTaxRate);
        // test for equality after update
        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());
        assertEquals(salesTaxRate1, salesTaxRate);
    }
}