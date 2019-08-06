package com.company;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/*Task:
 *
 */
public class City {
    private String name;
    private int population;

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public static String handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void checkCity(Map<String, Integer> map) {
        System.out.println("Hi, I have a map of all the largest cities in the US. What is the minimum population of the"
                + "cities you'd like to look at?");
        int min = Integer.parseInt(handleInput());

        for (Map.Entry<String,Integer> entry : map.entrySet())
            if (entry.getValue() >= min) {
                System.out.println("State = " + entry.getKey() +
                        ", " + entry.getValue());
            }

    }
    public static void main(String[] args) {
        int newYork = 8654321;
        int losAngeles = 4563218;
        int chicago = 2716520;
        int denver = 704621;
        int desMoines = 217521;
        int atlanta = 486213 ;

        // create map of State/City
        Map<String, Integer> cities = new HashMap<>();
        cities.put("New York", newYork);
        cities.put("California", losAngeles);
        cities.put("Illinois", chicago);
        cities.put("Colorado", denver);
        cities.put("Idaho", desMoines);
        cities.put("Georgia", atlanta);

        checkCity(cities);

    }

}
