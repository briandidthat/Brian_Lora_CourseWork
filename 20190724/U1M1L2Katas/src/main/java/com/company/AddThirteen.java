package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a number.");
        int userInput = Integer.parseInt(scanner.nextLine());

        int sum = userInput + 13;

        System.out.println("The sum is " + sum + ".");
    }
}
