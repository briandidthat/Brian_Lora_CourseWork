package com.company;
import java.util.Scanner;

/*Task:
 *
 */
public class AddingValuesInALoop {

    public static int addIntegers() {
        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();
        int total = 1;

        while (userInput != 0) {
            System.out.println("Feel Free to enter another while you're at it. ");
            userInput = in.nextInt();
            total += userInput;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println("Enter as many integers as you'd like.");
        System.out.println("Your total is " + addIntegers());
    }
}
