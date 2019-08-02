package com.company.store;

public class Restaurant {
    private String name;
    private String address;
    private String chips;
    private String soda;
    private String chocolate;
    private String[] menuOptions;

    public Restaurant(String name, String address, String chips, String soda, String chocolate, String[] menuOptions) {
        this.name = name;
        this.address = address;
        this.chips = chips;
        this.soda = soda;
        this.chocolate = chocolate;
        this.menuOptions = menuOptions;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
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

    public String getChips() {
        return chips;
    }

    public String getSoda() {
        return soda;
    }

    public String getChocolate() {
        return chocolate;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }


}
