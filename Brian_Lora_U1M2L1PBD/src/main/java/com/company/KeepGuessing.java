package com.company;
import java.util.Scanner;

/*Task:
* Modify your previous number-guessing game so that they can guess until they get it right. That means it will
* keep looping as long as the guess is different from the secret number. Use a  while loop.
 */

public class KeepGuessing {

    public static void returnAnswer(boolean ans, int guess) {
        if (ans) {
            System.out.println("That's right!  My secret number was " + guess + "!");

        } else {
            System.out.println("Your guess: " + guess);
            System.out.println("Sorry, but I was really thinking of another number. Try again.");
        }
    }

    public static void playGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the guessing game! Please pick a number from 1-10.");

        int number = 8;
        int guess = in.nextInt();

        while (guess != number) {
            returnAnswer(false, guess);
            guess = in.nextInt();
        }
        returnAnswer(true, guess);
    }

    public static void main(String[] args) {
        playGame();
    }
}
