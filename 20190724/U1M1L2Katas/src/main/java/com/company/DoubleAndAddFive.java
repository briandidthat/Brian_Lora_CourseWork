package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    /** Task:
     * Store input for one number, double then add 5. Print to the console.
     * Will need Scanner for input ( System.in ).
     * Two integers.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int num = Integer.parseInt(scanner.nextLine());

        int newNum = (num * 2) + 5;

        System.out.println("The new total is " + newNum + ".");

    }
}
