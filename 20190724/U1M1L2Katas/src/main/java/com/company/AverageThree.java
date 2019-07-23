package com.company;
import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

        // declare scanner instance
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! please input a first number.");
        int firstNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Hi! please input a second number.");
        int secondNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Hi! please input a third number.");
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int sum = firstNumber + secondNumber + thirdNumber / 3;

        // output the sum of the three numbers the user provided.
        System.out.println("The sum of the three numbers is " +sum+".");
    }
}
