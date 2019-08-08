package com.company;

/*Task:
 *
 */
public class IceCreamShop {
    private String[] iceCreamNames;
    private IceCream iceCream;

    public IceCreamShop(String[] iceCreamNames, IceCream iceCream) {
        this.iceCreamNames = iceCreamNames;
        this.iceCream = iceCream;
    }

    public void setIceCreamNames(String[] iceCreamNames) {
        this.iceCreamNames = iceCreamNames;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String[] getIceCreamNames() {
        return iceCreamNames;
    }

    public IceCream getIceCream() {
        return iceCream;
    }


}
