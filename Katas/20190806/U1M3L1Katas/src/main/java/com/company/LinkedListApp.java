package com.company;

import java.util.Collections;
import java.util.LinkedList;


public class LinkedListApp {

    public static int total(LinkedList<Integer> numbers) {
        int sum = 0;
        System.out.println("\n==> List Example..");
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

    public static int totalEven(LinkedList<Integer> numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {
        String temp = strings.get(0);
        strings.set(0,strings.get(strings.size() - 1));
        strings.set(strings.size() - 1, temp);

        return strings;
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {
        // Use Collections utility to reverse for me.
        Collections.reverse(numbers);
        LinkedList<Integer> reversed = new LinkedList<>();
        reversed.addAll(numbers);

        return reversed;
    }

    public static LinkedList<Integer>lessThanFive(LinkedList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        LinkedList<Integer> lessThanFive = new LinkedList<>();

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThanFive.add(num);
                numLessThanFive--;
            }
        }

        return lessThanFive;
    }
}
