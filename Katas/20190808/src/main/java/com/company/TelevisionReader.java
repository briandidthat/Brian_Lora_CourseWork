package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/*Task:
* Using the data provided in `televisions.json`, complete the following. Use lambdas and streams for all of these
* where appropriate.
* Read the data from the `.json` and store it as a `List`.
* Find all televisions with a screen size greater than 60 inches. Use the `.forEach` method to print out all entries.
* Group all televisions into a `Map` by `brand`. Print out the list of brands.
* Find and display the average `screenSize`.
* Find and display the largest screen.
 */

public class TelevisionReader {
    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisionList;

            televisionList = mapper.readValue(new File("televisions.json"),
                    new TypeReference<List<Television>>(){});

            // Define screen size for filter method and print all entries that pass condition
            int screenSize = 60;
            televisionList
                    .stream()
                    .filter(tv ->  tv.getScreenSize() > screenSize)
                    .forEach(tv -> {
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("ScreenSize: " + tv.getScreenSize());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("================");
                    });

            // Grouping all tvs by brand.
            Map<String, List<Television>> groupedTvs =
                    televisionList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = groupedTvs.keySet();
            // Printing all brands
            System.out.println("BRANDS \n");
            for(String key : keys) {
                System.out.println(key);
            }
            System.out.println("================");

            // Get average screen size
            double avgScreenSize =
                    televisionList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .average()
                            .getAsDouble();
            System.out.println("Average screen size is: " + avgScreenSize);

            // Get largest screen size
            int maxScreenSize =
                    televisionList
                            .stream()
                            .mapToInt(tv -> tv.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Max screen size: " + maxScreenSize);


        } catch (FileNotFoundException e) {
            System.out.println("We are having issues finding your file. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("We are experiencing errors buddy. " + e.getMessage());
        }
    }
}
