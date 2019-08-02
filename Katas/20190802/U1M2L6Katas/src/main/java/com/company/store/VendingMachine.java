package com.company.store;

/*Task:
 *
 */
public class VendingMachine {
    private int options;
    private String make;
    private String chips;
    private String chocolate;
    private String mints;
    private String gum;
    private String popCorn;

    public VendingMachine(int options, String make, String chips, String chocolate, String mints,
                          String gum, String popCorn) {
        this.options = options;
        this.make = make;
        this.chips = chips;
        this.chocolate = chocolate;
        this.mints = mints;
        this.gum = gum;
        this.popCorn = popCorn;
    }
    // SETTERS
    public void setOptions(int options) {
        this.options = options;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public void setMints(String mints) {
        this.mints = mints;
    }

    public void setGum(String gum) {
        this.gum = gum;
    }

    public void setPopCorn(String popCorn) {
        this.popCorn = popCorn;
    }

    // GETTERS
    public int getOptions() {
        return options;
    }

    public String getMake() {
        return make;
    }

    public String getChips() {
        return chips;
    }

    public String getChocolate() {
        return chocolate;
    }

    public String getMints() {
        return mints;
    }

    public String getGum() {
        return gum;
    }

    public String getPopCorn() {
        return popCorn;
    }


}
