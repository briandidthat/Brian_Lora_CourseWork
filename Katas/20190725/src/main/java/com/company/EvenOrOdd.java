package com.company;
import java.util.Scanner;

/**Task:
 * Write a program that takes user input (integer) and prints whether it's even or odd.
 * Will need Scanner (System.in), Test input val
 */

public class EvenOrOdd {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a number.");
        int num = in.nextInt();

        if (num % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
