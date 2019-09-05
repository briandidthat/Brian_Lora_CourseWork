package com.company.BrianLoraU1Capstone.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {
    private int id;
    private String name;
    private String itemType;
    private int quantity;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;


    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    //  GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getItemType() {
        return itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getItemType(), that.getItemType()) &&
                Objects.equals(getSubTotal(), that.getSubTotal()) &&
                Objects.equals(getTax(), that.getTax()) &&
                Objects.equals(getProcessingFee(), that.getProcessingFee()) &&
                Objects.equals(getTotal(), that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getItemType(), getQuantity(), getSubTotal(),
                getTax(), getProcessingFee(), getTotal());
    }
}
