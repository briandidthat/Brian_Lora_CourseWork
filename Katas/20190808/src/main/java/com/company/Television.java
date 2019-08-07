package com.company;

/*Task:
 * CREATE CLASS FOR READING
 */
public class Television {

    private String brand;
    private String model;
    private int price;
    private int screenSize;

    public Television(String brand, String model, int price, int screenSize) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
    }

    public Television() {

    }

    //SETTERS
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    //GETTERS
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getPrice() {
        return price;
    }
}
