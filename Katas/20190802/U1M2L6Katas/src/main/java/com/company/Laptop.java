package com.company;

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

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
