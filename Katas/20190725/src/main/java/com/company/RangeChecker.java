package com.company;
import java.util.Scanner;

/**Task:
 * Write a program that asks the user for a number between 15-32 (not inclusive).
 * Continue to prompt the user until they provide a number in that range.
 * Then, output to console.
 * Will need Scanner ( System.in ), While Loop
 */

public class RangeChecker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Hi, please enter a number from 15-32");
        int num = in.nextInt();

        do {
             System.out.println("Invalid selection, please select another number.");
             num = in.nextInt();
        } while(num <= 15 || num >= 32);

        System.out.println(num);
    }
}
