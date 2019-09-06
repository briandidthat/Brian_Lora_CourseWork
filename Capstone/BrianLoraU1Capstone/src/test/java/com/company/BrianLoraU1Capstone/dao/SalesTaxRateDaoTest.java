package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

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

    }

    @Test
    public void updateSalesTaxRate() {

    }
}