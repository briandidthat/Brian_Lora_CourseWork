package com.company;/*Task:
 *
 */

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void move(int deltaX, int deltaY) {
       this.xPosition = deltaX;
       this.yPosition = deltaY;
    }

    public void click() {

    }

}
