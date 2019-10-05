package com.trilogyed.gamestore.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;


public class Invoice {
    private int invoiceId;
    @NotNull(message = "Please enter a value for name.")
    private String name;
    @NotNull(message = "Please enter a value for street.")
    private String street;
    @NotNull(message = "Please enter a value for city.")
    private String city;
    @NotNull(message = "Please enter a value for state.")
    private String state;
    @NotNull(message = "Please enter a value for zipCode.")
    private String zipCode;
    @NotNull(message = "Please enter a value for itemType.")
    private String itemType;
    @NotNull(message = "Please enter a value for itemId.")
    private int itemId;
    private BigDecimal unitPrice;
    @NotNull(message = "Please enter a value for quantity.")
    private int quantity;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;

    // SETTERS
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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

    // GETTERS
    public int getInvoiceId() {
        return invoiceId;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
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
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                itemId == invoice.itemId &&
                quantity == invoice.quantity &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipCode.equals(invoice.zipCode) &&
                itemType.equals(invoice.itemType) &&
                Objects.equals(unitPrice, invoice.unitPrice) &&
                Objects.equals(subTotal, invoice.subTotal) &&
                Objects.equals(tax, invoice.tax) &&
                Objects.equals(processingFee, invoice.processingFee) &&
                Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipCode, itemType, itemId, unitPrice,
                quantity, subTotal, tax, processingFee, total);
    }
}
