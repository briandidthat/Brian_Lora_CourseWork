package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a number.");
        int userInput = Integer.parseInt(scanner.nextLine());
        int newTotal = userInput + 5 * 2;

        System.out.println("The new value is " + newTotal + ".");
    }
}
