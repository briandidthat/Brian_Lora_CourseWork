package com.company;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();

            int petIndex = Pets.choosePet();

            String chosenPet = Pets.retrievePet(petIndex);

            Pets.writePetToFile(chosenPet);

            System.out.println("New saved animals file:");
            Pets.readPetsFromFile();
        }catch (IOException e){
            System.out.println("This is an error: " + e);
        }



    }
}
