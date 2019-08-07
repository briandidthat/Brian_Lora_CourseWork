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

    public Phone(String brand, String model, String processor, int storage, int price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.storage = storage;
        this.price = price;
    }

    public Phone() {

    }
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
