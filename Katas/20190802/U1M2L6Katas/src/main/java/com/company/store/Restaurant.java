package com.company.store;
import com.company.interfaces.Vendor;

public class Restaurant implements Vendor {
    private String name;
    private String address;
    private String soda;
    private String[] menuOptions;

    public Restaurant(String name, String address, String soda, String[] menuOptions) {
        this.name = name;
        this.address = address;
        this.soda = soda;
        this.menuOptions = menuOptions;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setSoda(String soda) {
        this.soda = soda;
    }
    public void setMenuOptions(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    // GETTERS
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getSoda() {
        return soda;
    }
    public String[] getMenuOptions() {
        return menuOptions;
    }


    public void orderSoda(String soda) {
        System.out.println("Ice cold " + soda + " coming right up!");
    }

    @Override
    public void chargeCustomer(int total) {

    }
}
