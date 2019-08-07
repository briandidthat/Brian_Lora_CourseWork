package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Task:
* Create an ArrayList of Integers. Fill up the list with ten random numbers, each from 1 to 100.
* Then display the contents of the ArrayList on the screen.
* NOTE: You must use a loop to fill up the list.
*/

public class BasicArrayLists2 {

    // Generate random number
    public static int generateRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<Integer>();
        // Loop over list and add random number to list
        for (int i =0; i < 10; i ++) {
            randomList.add(generateRandom());
        }

        System.out.println( "ArrayList: " + randomList );
    }
}
