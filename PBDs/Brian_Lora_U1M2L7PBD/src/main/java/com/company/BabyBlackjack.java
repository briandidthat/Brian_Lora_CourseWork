package com.company;
import java.util.Scanner;
import java.util.Random;

/*Task:
 * Write a program that allows a human user to play a single hand of "blackjack" against a dealer.
 * Pick two values from 1-10 for the player. These are the player's "cards".
 * Pick two more values from 1-10 for the dealer. Whoever has the highest total is the winner.
 * There is no betting, no busting, and no hitting. Save that for real blackjack.
 */
public class BabyBlackjack {

    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(10+1);
    }

    public static String calculateSum() {
        int p1 = generateRandomInt();
        int p2 = generateRandomInt();
        System.out.println("Your cards: "+ p1 + " " +  p2);

        int d1 = generateRandomInt();
        int d2 = generateRandomInt();
        System.out.println("Dealer's cards: "+ d1 +" "+  d2);

        int playerTotal = p1 + p2;
        int dealerTotal = d1 + d2;

        if (playerTotal > dealerTotal) {
            return "Player won!";
        } else {
            return "Dealer won!";
        }
    }

    public static void playGame() {
        System.out.println("WELCOME TO BLACKJACK!!!\n Dealer shuffling......\n Bets taken. Cards coming up\n");
        System.out.println(calculateSum());
    }

    public static void main(String[] args) {
        playGame();
    }
}
