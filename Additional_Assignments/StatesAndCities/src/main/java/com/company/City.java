package com.company;

import java.util.ArrayList;
import java.util.List;

/*Task:
 *
 */
public class City {
    private String name;
    private int population;

    public City() {

    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
