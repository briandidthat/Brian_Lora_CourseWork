package com.company;

import java.util.List;

/*Task:
 *
 */
public class IceCreamShop {
    public List<IceCream> iceCreamList;
    private IceCream iceCream;
    private int customerTotal;

    public IceCreamShop(List<IceCream> iceCreamList, IceCream iceCream) {
        this.iceCreamList= iceCreamList;
        this.iceCream = iceCream;
    }

    public List<IceCream> getIceCreamList() {
        return iceCreamList;
    }

    public void setIceCreamList(List<IceCream> iceCreamList) {
        this.iceCreamList = iceCreamList;
    }

    public void setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public void sellIceCream(IceCream iceCream) {
        iceCreamList.remove(iceCream);
        customerTotal += iceCream.getPrice();
    }
}
