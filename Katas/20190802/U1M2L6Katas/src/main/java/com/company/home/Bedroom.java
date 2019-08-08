package com.company.home;

/*Task:
 *
 */
public class Bedroom {
    private int sqFeet;
    private int windows;

    public Bedroom(int sqFeet, int windows) {
        this.sqFeet = sqFeet;
        this.windows = windows;
    }

    public Bedroom() {

    }

    public void setSqFeet(int sqFeet) {
        this.sqFeet = sqFeet;
    }

    public void setWindows(int windows) {
        windows = windows;
    }

    public int getSqFeet() {
        return sqFeet;
    }

    public int getWindows() {
        return windows;
    }
}
