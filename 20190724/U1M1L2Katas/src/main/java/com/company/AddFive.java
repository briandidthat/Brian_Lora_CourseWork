package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a first number.");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a second number.");
        int secondNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a third number.");
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a fourth number.");
        int fourthNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a fifth number.");
        int fifthNumber = Integer.parseInt(scanner.nextLine());

        int sum = firstNumber + secondNumber + thirdNumber + fourthNumber + fifthNumber;

        // output the numbers the user provided
        System.out.println("The sum of the five numbers is " +sum+".");
    }
}
