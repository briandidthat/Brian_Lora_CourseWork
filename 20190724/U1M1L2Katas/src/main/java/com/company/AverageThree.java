package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AverageThree {

    /** Task:
     * Take input for three numbers.
     * Will need Scanner for input ( System.in ) and DecimalFormat formatter.
     * Four doubles.
     * Assignment didn't say print, but i'm going to print it anyways.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick any number.");
        double firstNum = scanner.nextDouble();

        System.out.println("Now, pick a  second number.");
        double secondNum = scanner.nextDouble();

        System.out.println("Finally, pick a third number.");
        double thirdNum = scanner.nextDouble();

        double average = ( firstNum + secondNum + thirdNum ) / 3;

        DecimalFormat newSum = new DecimalFormat("0.00");

        System.out.println("The average of the three numbers you provided is " + newSum.format(average) + ".");

    }
}
