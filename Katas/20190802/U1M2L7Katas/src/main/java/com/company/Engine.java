package com.company;

/*Task:
 *
 */
public class Engine {
    private int horsePower;
    private int maxSpeed;
    private String make;

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
