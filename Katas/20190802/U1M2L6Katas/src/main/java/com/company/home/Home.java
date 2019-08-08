package com.company.home;

public class Home {
    private String name;
    private String address;
    private Bathroom bathroom;
    private Patio patio;
    private Kitchen kitchen;
    private int numOfBedrooms;

    public Home(String address, int numOfBedrooms, Bathroom bathroom, Patio patio, Kitchen kitchen) {
        this.address = address;
        this.bathroom = bathroom;
        this.patio = patio;
        this.kitchen = kitchen;
        this.numOfBedrooms = numOfBedrooms;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }
    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    // GETTERS
    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public String getAddress() {
        return address;
    }
    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public Patio getPatio() {
        return patio;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }


}
