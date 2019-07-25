package com.company;
import java.util.Scanner;

/**Task:
 * Vote (18+)
 * Drink alcohol (21+)
 * Be president (35+)
 * Is eligible for AARP (55+)
 * Can retire (65+)
 * Is an octogenerian (80-89)
 * Is more than a century old (100+)
 * Will Need Scanner (System.in)
 */

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your age.");
        int age = in.nextInt();


        if (age >=18 && age < 21) {
            System.out.println("You can vote");
        } else if (age >= 21 && age < 35) {
            System.out.println("You can vote");
            System.out.println("You can drink alcohol.");
        } else if (age >= 35 && age < 55) {
            System.out.println("You can vote");
            System.out.println("You can drink alcohol.");
            System.out.println("You can be President.");
        } else if (age >= 55 && age < 65) {
            System.out.println("You can vote");
            System.out.println("You can drink alcohol.");
            System.out.println("You can be President.");
            System.out.println("You are eligible for AARP.");
        } else if (age >= 65 && age < 80) {
            System.out.println("You can vote");
            System.out.println("You can drink alcohol.");
            System.out.println("You can be President.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
        } else if (age >= 80 && age < 90) {
            System.out.println("You can vote");
            System.out.println("You can drink alcohol.");
            System.out.println("You can be President.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
            System.out.println("You are an octogenerian.");
        } else if (age >= 100) {
            System.out.println("You can vote.");
            System.out.println("You can drink alcohol.");
            System.out.println("You can be President.");
            System.out.println("You are eligible for AARP.");
            System.out.println("You can retire.");
            System.out.println("You are more than a century old.");
        } else {
            System.out.println("You are too young.");
        }
    }
}
