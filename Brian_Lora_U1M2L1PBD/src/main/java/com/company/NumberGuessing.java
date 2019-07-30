package com.company;
import java.util.Scanner;

/* Task:
 * Create a number-guessing game to actually pick a random number from 1 to 10 and have the user try to guess that.
 * Tell them if they get it right or wrong, and if they get it wrong, show them what the random number was.
 * Only one guess per game.
 */

public class NumberGuessing {

    public static void makeGuess() {
        int number = 3;

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the guessing game! Please pick a number from 1-10.");
        int userGuess = in.nextInt();

        if (userGuess == number) {
            System.out.println("Your guess: " + userGuess);
            System.out.println("That's right!  My secret number was " +number + "!");
        } else {
            System.out.println("Your guess: " + userGuess);
            System.out.println("Sorry, but I was really thinking of " + number +".");
        }
    }

    public static void main(String[] args) {
        makeGuess();
    }
}
