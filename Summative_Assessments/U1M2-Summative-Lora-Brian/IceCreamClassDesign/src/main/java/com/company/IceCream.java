package com.company;

/*Task:
 *
 */
public class IceCream {
    private String flavor;
    private int price;
    private int quantity;

    public IceCream(String flavor, int price,  int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    public IceCream() {

    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
