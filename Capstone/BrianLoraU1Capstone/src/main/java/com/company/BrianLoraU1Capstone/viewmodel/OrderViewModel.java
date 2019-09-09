package com.company.BrianLoraU1Capstone.viewmodel;


import javax.validation.constraints.NotNull;
import java.util.Objects;

public class OrderViewModel {
    private int id;
    @NotNull(message="Please supply a value for state")
    private String name;
    @NotNull(message="Please supply a value for street")
    private String street;
    @NotNull(message="Please supply a value for city")
    private String city;
    @NotNull(message="Please supply a value for state")
    private String state;
    @NotNull(message="Please supply a value for zip")
    private String zip;
    @NotNull(message="Please supply a value for itemType")
    private String itemType;
    @NotNull(message="Please supply a value for itemId")
    private int itemId;
    @NotNull(message="Please supply a value for quantity")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderViewModel that = (OrderViewModel) o;
        return id == that.id &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zip.equals(that.zip) &&
                itemType.equals(that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zip, itemType, itemId, quantity);
    }
}
