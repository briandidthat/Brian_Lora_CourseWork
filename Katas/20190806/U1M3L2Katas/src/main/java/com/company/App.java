package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {

    public void printKeys(Map<String, String> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> map) {
        Set<String> values = map.keySet();
        for (String value : values) {
            System.out.println(map.get(value));
        }
    }

    public void printKeysAndValues(Map<String, String> map) {
        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

    public Map mapFun(Map<String, Integer> map) {
        map.put("Ford Explorer",2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler", 2003);
        return map;
    }

    public List listCars(List<Car> cars) {
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();
        List<Car> toyotaList = new ArrayList<>();

        return cars;
    }

    public static void main(String[] args) {

    }
}
