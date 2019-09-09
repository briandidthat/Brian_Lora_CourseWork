package com.company.BrianLoraU1Capstone.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {
    private int id;
    @NotNull(message="Please supply a value for name")
    private String name;
    @NotNull(message="Please supply a value for street")
    private String street;
    @NotNull(message="Please supply a value for city")
    private String city;
    @NotNull(message="Please supply a value for state")
    private String state;
    @NotNull(message="Please supply a value for state")
    private String zipCode;
    @NotNull(message="Please supply a value for the item type")
    private String itemType;
    @NotNull(message="Please supply a value for item id")
    private int itemId;
    private BigDecimal unitPrice;
    @NotNull(message="Please supply a value for quantity")
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


    //  GETTERS
    public int getId() {
        return id;
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
        InvoiceViewModel that = (InvoiceViewModel) o;
        return id == that.id &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipCode.equals(that.zipCode) &&
                itemType.equals(that.itemType) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(subTotal, that.subTotal) &&
                Objects.equals(tax, that.tax) &&
                Objects.equals(processingFee, that.processingFee) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipCode, itemType, itemId, unitPrice,
                quantity, subTotal, tax, processingFee, total);
    }
}
