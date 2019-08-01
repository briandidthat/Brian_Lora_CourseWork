package com.company;
import java.util.Scanner;

/** Task: ValidNumber
 * This program prompts the user for a number between 1 and 10 and keeps asking until the entered number is in range.
 * The program must do the following:
 * Prompt the user to enter a number between 1 and 10.
 * If the user enters a number less than 1 or greater than 10, display the following error message and
 * prompt the user for another entry: "You must enter a number between 1 and 10, please try again."
 * When the user enters a valid number, print the number to the screen and exit.
 */

public class ValidNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 10.");
        int num = in.nextInt();

        // Continue prompting the user for an answer until num is between 1 && 10.
        while(num < 1 || num > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            num = in.nextInt();
        }

        System.out.println(num);
    }
}
