package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a first number.");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Now, input a second number.");
        int secondNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Finally, input a second number.");
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int sum = firstNumber * secondNumber * thirdNumber;

        System.out.println("The product of the three numbers is " +sum+".");
    }
}