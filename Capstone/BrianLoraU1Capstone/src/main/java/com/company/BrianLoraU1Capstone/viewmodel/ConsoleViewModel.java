package com.company.BrianLoraU1Capstone.viewmodel;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Objects;


public class ConsoleViewModel {

    private int id;
    @NotEmpty(message="Please supply a value for model")
    private String model;
    @NotEmpty(message="Please supply a value for manufacturer")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @NotEmpty(message="Please supply a value for price")
    private BigDecimal price;
    @NotEmpty(message="Please supply a value for quantity")
    private int quantity;

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // GETTERS
    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }


    public String getMemoryAmount() {
        return memoryAmount;
    }


    public String getProcessor() {
        return processor;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getModel(), that.getModel()) &&
                Objects.equals(getManufacturer(), that.getManufacturer()) &&
                Objects.equals(getMemoryAmount(), that.getMemoryAmount()) &&
                Objects.equals(getProcessor(), that.getProcessor()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getManufacturer(), getMemoryAmount(),
                getProcessor(), getPrice(), getQuantity());
    }
}
