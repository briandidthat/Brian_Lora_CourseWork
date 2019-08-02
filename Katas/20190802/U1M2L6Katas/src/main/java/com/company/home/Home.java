package com.company.home;

public class Home {
    private String name;
    private String address;
    private String bathroom;
    private String livingRoom;
    private String kitchen;
    private int numOfBedrooms;

    public Home(String name, String address, String bathroom, String livingRoom, String kitchen, int numOfBedrooms) {
        this.name = name;
        this.address = address;
        this.bathroom = bathroom;
        this.livingRoom = livingRoom;
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

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public void setLivingRoom(String livingRoom) {
        this.livingRoom = livingRoom;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    // GETTERS
    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    public String getBathroom() {
        return bathroom;
    }

    public String getLivingRoom() {
        return livingRoom;
    }

    public String getKitchen() {
        return kitchen;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

}
