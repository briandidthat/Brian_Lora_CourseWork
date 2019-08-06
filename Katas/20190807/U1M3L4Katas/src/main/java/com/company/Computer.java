package com.company;
import com.opencsv.bean.CsvBindByName;

/*Task:
 *
 */
public class Computer {
    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String cpu;
    @CsvBindByName(column = "RAM")
    private int ram;
    @CsvBindByName(column = "StorageSize")
    private int storageSize;

    //SETTERS
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    //GETTERS
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageSize() {
        return storageSize;
    }


}
