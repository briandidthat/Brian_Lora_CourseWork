package com.company;
import java.util.Scanner;
import java.util.Random;
/*Task:
* This is the original "ball and cups" game where you try to find out which cup has the ball under it. You may play
* with three cups and a ball, three cards (two jacks and an ace), or three doors and a car. Basically, randomly
* select a cup to hide the "ball". Let the player guess which cup hides the ball. The player wins,
* if they guess correctly.
 */
public class ThreeCardMonte {
    // get user input
    public static int getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(3 + 1);
    }

    public static void checkUserGuess(int guess) {
        int choice  = generateRandomInt();;
        boolean won = false;

        // mitigate issue of 0 coming out as the "random" number
        while(choice == 0) {
            choice = generateRandomInt();
        }

        if(guess == choice) {
            won = true;
            System.out.println("You won!");
        } else {
            System.out.println("You Lost! The ball was hiding under " + choice + ".");
        }
    }

    public static void playGame() {
        System.out.println("You arrive at Brian's Casino and plop down your cash.\nHe glances at you and starts to " +
                "play with three cups and a ball.\nHe stops, and asks....");
        System.out.println("Which cup is hiding the ball?");
        System.out.println("##    ##    ##");
        System.out.println("1     2     3");

        int guess = getInput();
        checkUserGuess(guess);
    }

    public static void main(String[] args) {
        playGame();
    }
}
