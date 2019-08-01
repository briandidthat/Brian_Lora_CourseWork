package com.company;
import java.util.Scanner;

/*Task:
* Write a program to allow the user to enter three integers. You must use do-while or while loops to enforce
* that these integers are in ASCENDING order, though duplicate numbers are allowed. Tell the user whether or
* not these integers would represent the sides of a right triangle.
 */
public class RightTriangleChecker {
    // get user input
    public static int getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void isValidTriangle() {
        int a,b,c;
        System.out.println("Enter three integers:");

        System.out.print("Side 1:");
        a = getInput();

        do{
            System.out.print("Side 2:");
            b = getInput();
            if (b < a)
                System.out.println(b+ " is smaller than " + a +". Try again.");
        } while (b < a);

        do{
            System.out.print("Side 3:");
            c = getInput();
            if (c < b)
                System.out.println(c+ " is smaller than " + b +". Try again.");
        }while (c < b);

        System.out.println("\nYour three sides are: " +a+" "+b+" "+c);
        if (a*a + b*b == c*c){
            System.out.println("Wee! These sides make a right triangle!");
        }else{
            System.out.println("NO! these sides do NOT make a right triangle.");
        }
    }

    public static void main(String[] args) {
        isValidTriangle();
    }
}
