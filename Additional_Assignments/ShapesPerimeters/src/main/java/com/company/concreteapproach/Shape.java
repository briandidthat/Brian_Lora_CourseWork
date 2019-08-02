package com.company.concreteapproach;

/*Task:
 * Create a basic class called Shape. Include properties for name, color, x coordinate, and y coordinate.
 * Also provide an empty implementation for area() and perimeter() methods.
 */
public class Shape {
    private String color;
    private String name;
    private int xCoordinate;
    private int yCoordinate;

    public double perimeter() {
        return 0;
    }

    public double area() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
