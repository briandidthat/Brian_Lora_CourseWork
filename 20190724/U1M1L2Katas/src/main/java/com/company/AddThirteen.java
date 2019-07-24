package com.company;

import java.util.Scanner;

public class AddThirteen {

    /** Task:
     * Store input for a number and add 13.
     * Will need Scanner for input ( System.in ).
     * Two integers.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int num = Integer.parseInt(scanner.nextLine());

        int sum = num + 13;

        System.out.println("The sum is " + sum + ".");
    }
}
