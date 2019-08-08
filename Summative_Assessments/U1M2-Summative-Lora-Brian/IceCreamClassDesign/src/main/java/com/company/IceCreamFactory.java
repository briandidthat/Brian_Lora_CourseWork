package com.company;

/*Task:
 *
 */
public class IceCreamFactory {
    private String[] IceCreamNames;
    private IceCream iceCream;
    private int quantity;

    public String[] getIceCreamNames() {
        return IceCreamNames;
    }

    public void setIceCreamNames(String[] iceCreamNames) {
        IceCreamNames = iceCreamNames;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}