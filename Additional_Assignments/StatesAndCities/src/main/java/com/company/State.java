package com.company;

import java.util.List;

/*Task:
 *
 */
public class State {
    private String name;
    private int population;
    private List<City> cities;
    private boolean isCapital;

    public State() {

    }

    public State(String name, int population, List<City> cities, boolean isCapital) {
        this.name = name;
        this.population = population;
        this.cities = cities;
        this.isCapital = isCapital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public List<City> getCities() {
        return cities;
    }

}
