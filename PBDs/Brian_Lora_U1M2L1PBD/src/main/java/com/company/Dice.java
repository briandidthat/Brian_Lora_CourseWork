package com.company;
import java.util.Random;

/*Task:
 * Write a program that simulates a dice roll by picking a random number from 1-6 and then picking a
 * second random number from 1-6. Add the two values together, and display the total.
 */

public class Dice {

    public static int generateRandom(int size) {
        Random random = new Random();
        return random.nextInt(size + 1);
    }

    public static void rollDice() {
        System.out.println(generateRandom(6));
    }

    public static void main(String[] args) {
        System.out.println("HERE COMES THE DICE!");
        rollDice();
        rollDice();
    }
}
