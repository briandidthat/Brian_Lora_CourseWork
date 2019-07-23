package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a first number.");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a second number.");
        int secondNumber = Integer.parseInt(scanner.nextLine());

        int total = secondNumber - firstNumber;

        System.out.println("The new total is " + total +".");
    }
}
