package com.company;/*Task:
 *
 */

public class Microwave {

    private String manufacturer;
    private String model;
    private String time;
    private int secondsLeft;
    private boolean running;

    public Microwave(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.running = false;
    }

    public void start(int secondsLeft) {
        this.running = true;
        this.secondsLeft = secondsLeft;
    }

    public void stop() {
        this.running = false;
        this.secondsLeft = 0;
    }

    public void clear() {
        this.time = "0:00";
        this.secondsLeft = 0;
        this.running = false;
    }

}
