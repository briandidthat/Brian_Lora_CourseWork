package com.company;

import com.company.readers.JsonReaderAndWriter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class InventoryManager {
    private List<Car> carList = new ArrayList<>();

    public InventoryManager() {

    }

    public void deleteCar(int id){
        this.carList.remove(id);
    }

    public void addCar(Car car){
        if (car != null) {
            this.carList.add(car);
        } else {
            System.out.println("buggy");
        }
    }

    public List<Car> listCars() {
        return this.carList;
    }

    public List<Car> searchCarsByMake(String make) {
        List<Car> carsByMake = new ArrayList<>();
        this.carList
                .stream()
                .filter(mk -> mk.getMake().equalsIgnoreCase(make))
                .forEach(mk -> {
                    carsByMake.add(mk);
                });
        return carsByMake;
    }

    public List<Car> searchCarsByModel(String model) {
        List<Car> carsByModel = new ArrayList<>();
        carList
                .stream()
                .filter(mk -> mk.getMake().equalsIgnoreCase(model))
                .forEach(mk -> {
                    carsByModel.add(mk);
                });
        return carsByModel;
    }

    public List<Car> searchCarsByColor(String color) {
        List<Car> carsByColor = new ArrayList<>();
        carList
                .stream()
                .filter(mk -> mk.getMake().equalsIgnoreCase(color))
                .forEach(mk -> carsByColor.add(mk));

        return carsByColor;
    }

    public List<Car> searchCarsByMileage(int mileage) {
        List<Car> carsByMileage = new ArrayList<>();
        carList
                .stream()
                .filter(mk -> mk.getMileage() <= mileage)
                .forEach(mk -> carsByMileage.add(mk));

        return carsByMileage;
    }

    public List<Car> searchCarsByYear(int year) {
        List<Car> carsByColor = new ArrayList<>();
        carList
                .stream()
                .filter(mk -> mk.getYear() >= year)
                .forEach(mk -> carsByColor.add(mk));

        return carsByColor;
    }

}
