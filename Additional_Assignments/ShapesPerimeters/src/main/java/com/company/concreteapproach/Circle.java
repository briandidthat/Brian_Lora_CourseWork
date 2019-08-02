package com.company.concreteapproach;

public class Circle extends Shape {
    private double radius;
    private double circumference;

    public Circle(double radius, double circumference) {
        this.radius = radius;
        this.circumference = circumference;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getRadius() {
        return radius;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
