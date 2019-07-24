package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    /** Task:
     * Store input for a number, add 5, then double. Print result.
     * Will need Scanner for input ( System.in ).
     * Two integers.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int num = Integer.parseInt(scanner.nextLine());

        int newTotal = (num + 5) * 2;

        System.out.println("The new value is " + newTotal + ".");
    }
}
