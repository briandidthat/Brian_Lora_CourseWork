package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.rmi.NoSuchObjectException;

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
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number." + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("The following file does not seem to exist: " + e.getMessage());
        } catch (WriteAbortedException e) {
            System.out.println("Something went wrong while writing your file.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please choose an available pet.");
        } catch (IOException e) {
            System.out.println("This is an error: " + e);
        } finally {
            System.out.println("Have a nice day!");
        }
    }
}
