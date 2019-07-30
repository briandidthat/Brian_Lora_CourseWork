package com.company;/*Task:
 *
 */

public class Tv {

    private String manufacturer;
    private String model;
    private String channel;
    private int volume;
    private int screenSize;
    private boolean powered;

    public Tv(String manufacturer, String model, int screenSize) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.powered = false;
    }

    public void togglePower() {
        this.powered = true;
    }
}
