package com.company;/*Task:
 *
 */

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafeSize) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.powered = false;
    }

    public void brew() {
        this.powered = true;
    }

    public void pourCoffee(int numCups) {
        this.powered = true;
        this.cupsLeft = this.cupsLeft - numCups;
    }
}
