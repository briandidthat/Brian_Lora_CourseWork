package com.company;

/*Task:
 *
 */
public class Phone {
    private String brand;
    private String model;
    private String processor;
    private int storage;
    private int price;

    //SETTERS
    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //GETTERS
    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public String getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public int getPrice() {
        return price;
    }
}
