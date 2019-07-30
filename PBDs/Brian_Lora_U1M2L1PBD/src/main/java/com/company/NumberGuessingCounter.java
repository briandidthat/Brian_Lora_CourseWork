package com.company;

import java.util.Scanner;

public class NumberGuessingCounter {

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

        // must initialize counter at 1 since the first input will not be inside loop
        int counter = 1;
        int number = 8;
        int guess = in.nextInt();

        while (guess != number) {
            returnAnswer(false, guess);
            guess = in.nextInt();
            counter +=1;
        }
        returnAnswer(true, guess);
        System.out.println("It only took you " +counter+ " tries.");
    }

    public static void main(String[] args) {
        playGame();
    }
}
