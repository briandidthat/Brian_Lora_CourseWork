package com.company.BrianLoraU1Capstone.dao;

import com.company.BrianLoraU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {
    private JdbcTemplate jdbcTemplate;

    // PREPARED STATEMENTS
    private static final String INSERT_SALES_TAX_RATE_SQL =
            "insert into sales_tax_rate (state, rate) values (?, ?)";
    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "select * from sales_tax_rate";
    private static final String SELECT_SALES_TAX_RATE_BY_STATE_SQL =
            "select * from sales_tax_rate where state = ?";
    private static final String UPDATE_SALES_TAX_RATE_SQL =
            "update sales_tax_rate set rate = ? where state = ?";
    private static final String DELETE_SALES_TAX_RATE_SQL =
            "delete from sales_tax_rate where state = ?";

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());

        return salesTaxRate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_BY_STATE_SQL, this::mapRowToSalesTaxRate, state);
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATES_SQL, this::mapRowToSalesTaxRate);
    }

    @Override
    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState());
    }

    @Override
    public void deleteSalesTaxRate(String state) {
        jdbcTemplate.update(DELETE_SALES_TAX_RATE_SQL, state);
    }

    // HELPER METHODS
    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        return salesTaxRate;
    }
}
