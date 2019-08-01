package com.company;
import java.util.Scanner;

/*Task:
 *
 */
public class AddingValuesInALoop {

    public static int handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static int calculateSum() {
        int userInput = handleInput();
        int total = 1;

        while (userInput != 0) {
            System.out.println("I will add up the numbers you give me.");
            userInput = handleInput();
            total += userInput;
            System.out.format("The total so far is %d. \n", total);
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println("Enter as many integers as you'd like.");
        System.out.println("Your total is " + calculateSum());
    }
}
