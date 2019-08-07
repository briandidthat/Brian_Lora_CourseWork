package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*Task:
 *
 */
public class TelevisionReader {
    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisionList;

            televisionList = mapper.readValue(new File("televisions.json"),
                    new TypeReference<List<Television>>(){});

        } catch (FileNotFoundException e) {
            System.out.println("We are having issues finding your file. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("We are experiencing errors buddy. " + e.getMessage());
        }
    }
}
