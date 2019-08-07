package com.company;

import java.util.ArrayList;
import java.util.List;

/*Task:
* Create an ArrayList of Integers. Fill up the list with 1,000 random numbers, each from 10 to 99.
* Then display the contents of the ArrayList on the screen in any way you like.
*/


public class BasicArrayLists3 {
    // Generate random numbers between the ranges of 10-99
    public static int generateRandom(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<Integer>();

        for (int i =0; i < 1000; i ++) {
            randomList.add(generateRandom(10,99));
        }
        System.out.println( "ArrayList: " + randomList );
    }
}
