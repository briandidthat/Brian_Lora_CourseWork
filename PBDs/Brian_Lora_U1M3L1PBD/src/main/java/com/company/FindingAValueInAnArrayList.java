package com.company;

/*Task:
 * Create an ArrayList that can hold Integers, and fill each slot with a different random value from 1-50.
 * Display those values on the screen, and then prompt the user for an integer. Search through the ArrayList,
 * and if the item is present, say so. It is not necessary to display anything if the value was not found. If the item
 * is in the ArrayList multiple times, it's okay if the program prints the message more than once.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArrayList {
    // Generate random number
    public static int generateRandom() {
        Random random = new Random();
        return random.nextInt(50) + 1;
    }

    public static int handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void main(String[] args) {
        int userSelection;
        List<Integer> randomList = new ArrayList<Integer>();
        //Populate list with random values
        for (int i = 0; i < 10; i++) {
            randomList.add(generateRandom());
        }
        // Ask for input from user to compare

        System.out.println("Value to find: ");
        userSelection = handleInput();

        System.out.println("Array contents: " + randomList);

        if (randomList.contains(userSelection)) {
            System.out.println(userSelection + " is in the ArrayList.");
        }
    }
}
