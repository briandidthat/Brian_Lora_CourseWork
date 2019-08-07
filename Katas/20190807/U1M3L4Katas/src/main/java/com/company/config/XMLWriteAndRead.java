package com.company.config;
import com.company.Car;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class XMLWriteAndRead {
    public static void main(String[] args) {

        PrintWriter writer = null;
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


        try {
            ObjectMapper mapper = new XmlMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            writer = new PrintWriter(new FileWriter("cars.xml"));

            writer.println(jsonCarList);

            writer.flush();
            writer.close();

            carList = mapper.readValue(new File("cars.xml"), new TypeReference<List<Car>>(){});

            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getMake());
                System.out.println(car.getColor());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
