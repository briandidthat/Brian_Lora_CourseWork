package com.company.BrianLoraU1Capstone.viewmodel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;


public class ConsoleViewModel {

    private int id;
    @NotNull(message="Please supply a value for model")
    private String model;
    @NotNull(message="Please supply a value for manufacturer")
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    @NotNull(message="Please supply a value for price")
    private BigDecimal price;
    @NotNull(message="Please supply a value for quantity")
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
        return id == that.id &&
                quantity == that.quantity &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                memoryAmount.equals(that.memoryAmount) &&
                processor.equals(that.processor) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
