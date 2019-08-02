package com.company;

/*Task:
* Create a Sedan class. It should extend Car and have the following properties
* and associated getters/setters:
* int numDoors, boolean poweredWindows
*/
public class Sedan extends Car {
    private int numDoors;
    private boolean poweredWindows;

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public void setPoweredWindows(boolean poweredWindows) {
        this.poweredWindows = poweredWindows;
    }

    public void getNumDoors() {
        System.out.println("this car has " +numDoors+ " doors." );
    }
}
