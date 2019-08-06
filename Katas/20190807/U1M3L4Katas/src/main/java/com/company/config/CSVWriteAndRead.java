package com.company.config;

import com.company.Car;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVWriteAndRead {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            //Write to files with FileWriter
            Writer writer = new FileWriter("cars.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();
            System.out.println("File was written.");


            carList = new CsvToBeanBuilder<Car>(new FileReader("cars.csv"))
                    .withType(Car.class).build().parse();

            for (Car car : carList) {
                System.out.println("=================================");
                System.out.println(car.getMake());
                System.out.println(car.getColor());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
