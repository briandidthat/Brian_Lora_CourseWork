package com.company;

public class Restaurant {
    private String chips;
    private String soda;
    private String chocolate;
    private String[] menuOptions;

    public Restaurant(String chips, String soda, String chocolate, String[] menuOptions) {
        this.chips = chips;
        this.soda = soda;
        this.chocolate = chocolate;
        this.menuOptions = menuOptions;
    }

    public String getChips() {
        return chips;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public String getSoda() {
        return soda;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }
}
