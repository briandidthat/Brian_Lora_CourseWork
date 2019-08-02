package com.company;
import com.company.interfaces.Vehicle;

/*Task:
 * Create a Car class. It should implement Vehicle and have the following properties
 * and associated getters/setters:
 * String make, String model, int milesTraveled
 */
public class Car implements Vehicle {
    private String make;
    private String model;
    private int milesTraveled;

    public void drive(int miles) {
        this.milesTraveled += miles;
    }

    public void displayMilesTraveled() {
        System.out.println("the amount of miles traveled is: " + milesTraveled);
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
