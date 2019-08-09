package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*Task:
* Write a program that creates an ArrayList which can hold Integers. Fill the ArrayList with random numbers
* from 1 to 100. Display the values in the ArrayList on the screen. Then use a linear search to find the largest value
* in the ArrayList, and display that value.
*/

public class GettingTheLargestValue {

    public static int generateRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    public static int getLargest(List<Integer> newList) {
        int largest = Integer.MIN_VALUE;

        for (int i =0; i < newList.size(); i++) {
            if(newList.get(i) > largest) {
                largest = newList.get(i);
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<Integer>();

        for (int i =0; i< 10; i++) {
            numList.add(generateRandom());
        }
        System.out.println("ArrayList: " + numList);
        System.out.format("The largest value is %d.", getLargest(numList));
    }
}
