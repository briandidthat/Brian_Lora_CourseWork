package com.company.abstractapproach;

public class Square extends Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public double area() {
        return (side * 2) * 2;
    }

    public double perimeter() {
        return side * 4;
    }


}
