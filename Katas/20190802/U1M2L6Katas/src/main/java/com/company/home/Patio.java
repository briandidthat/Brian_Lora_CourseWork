package com.company.home;

/*Task:
 *
 */
public class Patio {
    private int sqFeet;
    private boolean isDecorated;

    public Patio() {

    }

    public Patio(int sqFeet, boolean isDecorated) {
        this.sqFeet = sqFeet;
        this.isDecorated = isDecorated;
    }

    public void setSqFeet(int sqFeet) {
        this.sqFeet = sqFeet;
    }

    public void setDecorated(boolean decorated) {
        isDecorated = decorated;
    }

    public int getSqFeet() {
        return sqFeet;
    }

    public boolean isDecorated() {
        return isDecorated;
    }

}
