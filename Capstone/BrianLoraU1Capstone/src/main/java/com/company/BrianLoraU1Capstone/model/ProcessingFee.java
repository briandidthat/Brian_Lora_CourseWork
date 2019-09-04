package com.company.BrianLoraU1Capstone.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    private String productType;
    private BigDecimal fee;

    // SETTERS
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    // GETTERS
    public String getProductType() {
        return productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return Objects.equals(getProductType(), that.getProductType()) &&
                Objects.equals(getFee(), that.getFee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductType(), getFee());
    }
}
