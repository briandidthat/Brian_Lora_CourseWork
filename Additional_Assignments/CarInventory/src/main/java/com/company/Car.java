package com.company;


public class Car {
    private static int carCount;
    private String make;
    private String model;
    private String color;
    private int mileage;
    private int year;

    public Car(String make, String model, String color, int mileage, int year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.year = year;
        // Increment carCount in order to also know how many instances there are
        carCount++;
    }

    public Car() {
        carCount++;
    }

    public static void setCarCount(int carCount) {
        Car.carCount = carCount;
    }

    // SETTERS
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    // GETTERS
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }


}
