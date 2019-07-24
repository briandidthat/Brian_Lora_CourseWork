package com.company;

import java.util.Scanner;

public class SubtractTwo {

    /** Task:
     * Store input for a number and subtract the second number from the first.
     * Will need Scanner for input ( System.in ).
     * Two integers.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int firstNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Now, pick a second number.");
        int secondNum = Integer.parseInt(scanner.nextLine());

        int total = firstNum - secondNum ;

        System.out.println("The new total is " + total +".");
    }
}
