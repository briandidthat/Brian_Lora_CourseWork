package com.company;

/*Task:
* Create an ArrayList of Integers, and fill each slot with a different random value from 1-50. Display those values
* on the screen, and then prompt the user for an integer. Search through the ArrayList, and if the item is present,
* say so. If the value is not in the ArrayList, display a single message saying so. Just like the previous assignment,
* if the value is present more than once, you may display the message as many times as necessary.
*/

import java.util.*;

public class ArrayListThereOrNot {

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

        System.out.println("Array contents: " + randomList);
        // Ask for input from user to compare
        System.out.println("Value to find: ");
        userSelection = handleInput();

        if (randomList.contains(userSelection)) {
            System.out.println(userSelection + " is in the ArrayList.");
        } else {
            System.out.println(userSelection + " is not in the ArrayList.");
        }
    }
}
