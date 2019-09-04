package com.company.BrianLoraU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;


public class SalesTaxRate {
    private String state;
    private BigDecimal rate;

    public void setState(String state) {
        this.state = state;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return Objects.equals(getState(), that.getState()) &&
                Objects.equals(getRate(), that.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }
}
