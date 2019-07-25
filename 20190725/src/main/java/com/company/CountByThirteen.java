package com.company;
import java.util.Scanner;

/**Task:
 * Write a program that asks the user for a number and then prints a count from 0-that number counting by thirteen.
 * Will need Scanner ( System.in ), For loop that increments by 13. i+=13
 */

public class CountByThirteen {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter any number");
        int num = in.nextInt();

        for (int i = 0; i <= num; i += 13) {
            System.out.println(i);

        }
    }
}
