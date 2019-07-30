package com.company;
import java.util.Scanner;

/*Task:
* Write a program that picks a random number from 1-100. The user keeps guessing as long as their guess is wrong,
* and they've guessed less than 7 times. If their guess is higher than the number, say "Too high." If their guess
* is lower than the number, say "Too low." When they get it right, the game stops. Or, if they hit seven guesses,
* the game stops even if they never got it right.
*/

public class HiLo {


    public static void returnAnswer(int guess, int secretNumber) {
        if (guess == secretNumber) {
            System.out.println("That's right!  My secret number was " + guess + "!");
        } else if (guess < secretNumber) {
            System.out.println("Too low. Try again.");
        } else if (guess > secretNumber) {
            System.out.println("Too high. Try again.");
        } else {
            System.out.println("Your guess: " + guess);
        }
    }

    public static void playGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the guessing game! Please pick a number from 1-100.");

        // must initialize counter at 1 since the first input will not be inside loop
        int counter = 1;
        int secretNumber = 22;
        int guess = in.nextInt();


        while (counter < 7) {
            if (guess != secretNumber) {
                returnAnswer(guess, secretNumber);
                guess = in.nextInt();
                counter +=1;
            } else {
                returnAnswer(guess, secretNumber);
                return;
            }
        }
        returnAnswer(guess, secretNumber);
        System.out.println("It only took you " +counter+ " tries.");
    }

    public static void main(String[] args) {
        playGame();
    }
}
