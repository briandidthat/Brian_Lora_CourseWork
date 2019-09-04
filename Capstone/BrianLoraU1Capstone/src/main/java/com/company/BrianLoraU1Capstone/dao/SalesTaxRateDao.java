package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {
    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);
    SalesTaxRate getSalesTaxRate(String state);

    List<SalesTaxRate> getAllSalesTaxRates();

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);
    void deleteSalesTaxRate(int id);
}
