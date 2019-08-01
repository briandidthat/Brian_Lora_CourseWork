package com.company;
import java.util.Random;

/*Task:
 *
 */
public class ShorterDoubleDice {

    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(6 + 1);
    }

    public static void rollDice() {
        int roll1, roll2, total;

        do {
            roll1 = generateRandomInt();
            roll2 = generateRandomInt();
            total = roll1 + roll2;

            System.out.println( "Roll #1: " + roll1 );
            System.out.println( "Roll #2: " + roll2 );
            System.out.println( "Your total is " + total + "!\n" );
        } while(roll1 != roll2);
    }

    public static void main(String[] args) {
        System.out.println( "HERE COMES THE DICE!" );
        rollDice();
    }

}
