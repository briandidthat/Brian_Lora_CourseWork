package com.company.config;

import com.company.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*Task:
 *
 */
public class JSONWriteAndRead {

    public static void main(String[] args) {

        PrintWriter writer = null;
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            //Write to files with FileWriter
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            writer = new PrintWriter(new FileWriter("cars.json"));
            writer.println(jsonCarList);

            carList = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>(){});

            //Iterate over the files in carList and print to screen
            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getMake());
                System.out.println(car.getColor());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
            }

        }catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
