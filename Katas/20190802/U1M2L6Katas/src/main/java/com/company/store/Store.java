package com.company.store;

import com.company.interfaces.Vendor;

public class Store implements Vendor {
    private String chips;
    private String soda;
    private String chocolate;

    public Store(String chips, String soda, String chocolate) {
        this.chips = chips;
        this.soda = soda;
        this.chocolate = chocolate;
    }

    // SETTERS
    public void setChips(String chips) {
        this.chips = chips;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    // GETTERS
    public String getChips() {
        return chips;
    }

    public String getSoda() {
        return soda;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void orderSoda(String soda) {
        System.out.println("Ice cold " + soda + " coming right up!");
    }

    public void chargeCustomer(int total) {

    }

}