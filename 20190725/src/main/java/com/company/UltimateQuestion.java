package com.company;
import java.util.Scanner;

/**Task:
 * Write a program that continues to ask for input between 1 and 100 until the user enters 42. Once they do, print--
 * "That's the number I was looking for! 42 is definitely the answer!"
 * Will need Scanner (System.in)
 */

public class UltimateQuestion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //Correct answer
        int num = 42;

        System.out.println("Hi, please input a number between 1-100");
        int guess = in.nextInt();

        //loop until the correct answer is provided.
        while(guess != num) {
            System.out.println("Please input another number.");
            guess = in.nextInt();
        }
        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}
