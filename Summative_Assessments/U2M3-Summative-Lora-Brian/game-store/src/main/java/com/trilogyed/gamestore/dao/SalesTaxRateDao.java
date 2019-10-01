package com.trilogyed.gamestore.dao;

import com.trilogyed.gamestore.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {
    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);
    SalesTaxRate getSalesTaxRate(String state);

    List<SalesTaxRate> getAllSalesTaxRates();

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);
    void deleteSalesTaxRate(String state);
}
