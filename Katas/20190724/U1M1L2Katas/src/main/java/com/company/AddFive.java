package com.company;

import java.util.Scanner;

public class AddFive {

    /** Task:
     * Store input for five integers and print the sum.
     * Will need Scanner for input ( System.in ).
     * Five integers.
     * Assignment didn't say print, but i'm going to print it anyways.
     * Probably could have used one int to save memory, but this is a relatively small program so it's OK.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int firstNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Now pick a second number.");
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Now pick a third number.");
        int thirdNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Now pick a fourth number.");
        int fourthNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Finally, pick a fifth number.");
        int fifthNum = Integer.parseInt(scanner.nextLine());

        int sum = firstNum + secondNum + thirdNum + fourthNum + fifthNum;

        // output the numbers the user provided
        System.out.println("The sum of the five values you entered is " + sum + ".");
    }
}
