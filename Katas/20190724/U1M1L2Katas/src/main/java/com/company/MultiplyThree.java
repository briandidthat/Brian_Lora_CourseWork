package com.company;

import java.util.Scanner;

public class MultiplyThree {

    /** Task:
     * Store input for three numbers and multiply them. Print the product.
     * Will need Scanner for input ( System.in ).
     * Four integers.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        int firstNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Now pick a second number.");
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.println("Finally, pick a third number.");
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = firstNum * secondNum * thirdNum;

        System.out.println("The product of the three numbers is " + sum + ".");
    }
}