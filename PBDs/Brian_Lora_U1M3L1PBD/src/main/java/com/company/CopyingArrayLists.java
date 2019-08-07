package com.company;

/*Task:
 * Write a program that creates an ArrayList of Integers. It should put ten random numbers from 1 to 100 in
 * the ArrayList. It should copy all the elements of that ArrayList into another ArrayList of the same size.
 * Then display the contents of both ArrayLists in any way you like.
 * STEPS:
 * Create an ArrayList of Integers
 * Fill the ArrayList with ten random numbers (1-100)
 * Copy each value from the ArrayList into another ArrayList of the same capacity
 * Change the last value in the first ArrayList to a -7
 * Display the contents of both ArrayLists
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    // Generate random number
    public static int generateRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<Integer>();
        List<Integer> randomList2;

        // Populate list with 10 random numbers
        for (int i =0; i < 10; i++) {
            randomList.add(generateRandom());
        }
        // copy contents of array 1 to array 2
        randomList2 = new ArrayList<>(randomList);
        // removing the last item and swapping with -7
        randomList.remove(randomList.size() -1);
        randomList.add(-7);

        System.out.println("ArrayList1: " + randomList);
        System.out.println("ArrayList2: " + randomList2);

    }
}
