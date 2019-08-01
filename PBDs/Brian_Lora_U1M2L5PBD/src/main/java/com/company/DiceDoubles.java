package com.company;
import java.util.Random;

/*Task:
 *
 */
public class DiceDoubles {

    public static int generateRandomInt() {
        Random random = new Random();
        return random.nextInt(6 + 1);
    }

    public static void rollDice() {
        int roll1 = generateRandomInt();
        int roll2 = generateRandomInt();
        int total;

        while(roll1 != roll2) {
            roll1 = generateRandomInt();
            roll2 = generateRandomInt();
            total = roll1 + roll2;

            System.out.println( "Roll #1: " + roll1 );
            System.out.println( "Roll #2: " + roll2 );
            System.out.println( "Your total is " + total + "!\n" );
        }
    }

    public static void main(String[] args) {
        System.out.println( "HERE COMES THE DICE!\n" );
        rollDice();
    }
}
