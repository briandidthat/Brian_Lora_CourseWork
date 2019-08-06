package com.company;

/*Task:
 *
 */
public class Television {
    private String brand;
    private String model;
    private int price;
    private int screenSize;

    //SETTERS
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //GETTERS
    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getBrand() {
        return brand;
    }
}
