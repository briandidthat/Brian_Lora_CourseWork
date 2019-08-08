package com.company;

/*Task:
 *
 */
public class IceCream {
    private String flavor;
    private int quantity;

    public IceCream(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    public IceCream() {

    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getQuantity() {
        return quantity;
    }
}
