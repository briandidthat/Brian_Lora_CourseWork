package com.company.readers;

import com.company.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderAndWriter {

    public List<Car> readFile() {
        List<Car> carList = new ArrayList<>();

        try {

            ObjectMapper mapper = new ObjectMapper();
            carList = mapper.readValue(new File("cars.json"), new TypeReference<List<Car>>() {});
            //Iterate over the files in carList and print to screen
            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getMake());
                System.out.println(car.getColor());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
            }

        } catch(JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch( IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        }
        return carList;
    }

    public void writeToFile(Car car) {
        //Write to files with FileWriter
        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCar = mapper.writeValueAsString(car);

            writer = new PrintWriter(new FileWriter("cars.json"));
            writer.println(jsonCar);

            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("wrong selection!");
        } finally {
            if(writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
