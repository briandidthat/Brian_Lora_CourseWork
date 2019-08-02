package com.company;

/*Create an Accord class. It should extend Sedan and have the following properties
* and associated getters/setters:
* String year,  Engine engine,  Transmission transmission
*/
public class Accord extends Sedan {
    private String year;
    private Engine engine;
    private Transmission transmission;

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public String getYear() {
        return year;
    }
}
