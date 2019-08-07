package com.company.readers;
import com.company.Computer;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class ComputerReader {

    public static void main(String[] args) {
        try {
            List<Computer> computerList;
            computerList = new CsvToBeanBuilder<Computer>(new FileReader("computers.csv"))
                    .withType(Computer.class).build().parse();

            for (Computer pc : computerList) {
                System.out.println("================");
                System.out.println(pc.getBrand());
                System.out.println(pc.getModel());
                System.out.println(pc.getRam());
                System.out.println(pc.getStorageSize());
                System.out.println(pc.getCpu());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
