package com.company;
import java.util.Random;

/*Task:
 * Write a program that simulates a random fortune from a fortune cookie. You must have at least six fortunes.
 * For bonus points, also add randomly-chosen lotto numbers to the fortune.
 */

public class FortuneCookie {

    public static int generateRandom(int size) {
        Random random =new Random();
        return random.nextInt(size);
    }

    public static void generateFortune() {
        String[] fortunes = {"The fortune you seek is in another cookie.","A closed mouth gathers no feet.",
                "A conclusion is simply the place where you got tired of thinking.","A cynic is only a frustrated " +
                "optimist.","A foolish man listens to his heart","If you look back, you'll soon be going that way."};

        int randomIdx = generateRandom(fortunes.length);
        System.out.println(fortunes[randomIdx]);
    }

    public static void generateLottery() {

    }

    public static void main(String[] args) {
        generateFortune();
    }
}
