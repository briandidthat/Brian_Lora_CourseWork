package com.company.laptop;

public class Laptop {
    private String graphicsCard;
    private String make;
    private String model;
    private String ram;
    private int memory;

    public Laptop(String graphicsCard, String make, String model, String ram, int memory) {
        this.graphicsCard = graphicsCard;
        this.make = make;
        this.model = model;
        this.ram = ram;
        this.memory = memory;
    }
    // SETTERS
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    // GETTERS
    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }

    public int getMemory() {
        return memory;
    }


}
