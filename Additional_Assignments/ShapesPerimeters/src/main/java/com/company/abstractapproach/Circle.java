package com.company.abstractapproach;

public class Circle extends Shape {
    private double radius;
    private double circumference;

    public Circle(double radius, double circumference) {
        this.radius = radius;
        this.circumference = circumference;
    }

    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }
}
