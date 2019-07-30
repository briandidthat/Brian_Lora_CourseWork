package com.company;
/*Task:
 *
 */

public class Radio {

    private String manufacturer;
    private String model;
    private String station;
    private int volume;
    private int numSpeaker;
    private boolean powered;

    public Radio(String manufacturer, String model, String station, int numSpeaker) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.station = station;
        this.numSpeaker = numSpeaker;
        this.powered = false;
    }

    public void togglePower() {
        this.powered = true;
    }
}
