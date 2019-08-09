package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*Task:
* Write a program that creates an ArrayList of Integers. Fill the ArrayList with random numbers from 1 to 100.
* Display the values in the ArrayList on the screen. Then use a linear search to find the largest value
* in the ArrayList, and display that value and its slot number.
*/

public class LocatingTheLargestValue {
    public static int generateRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
    public static void printLargestIndex(List<Integer> numList) {
        int largest = Integer.MIN_VALUE;
        int largestIdx = 0;

        for (int i =0; i < numList.size(); i++) {
            if(numList.get(i) > largest) {
                largest = numList.get(i);
                largestIdx = numList.indexOf(largest);
            }
        }

        System.out.format("The largest value is %d, which is in slot %d.", largest,largestIdx);
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();

        for (int i =0; i< 10; i++) {
            numList.add(generateRandom());
        }

        System.out.println("ArrayList: " +numList);
        printLargestIndex(numList);
    }
}
