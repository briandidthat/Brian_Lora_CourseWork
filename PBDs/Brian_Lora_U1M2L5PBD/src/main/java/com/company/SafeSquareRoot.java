package com.company;
import java.util.Scanner;

/*Task:
 * Write a program to take the square root of a number typed in by the user. Your program should use a loop to ensure
 * that the number they typed in is positive. If the number is negative, you should print out some sort of warning and
 * make them type it in again.Note that it is possible to do this program with either a while loop or a do-while loop.
 * You can get the square root of a number n with Math.sqrt(n). Make sure you don't do this until the loop is done
 * and you know for sure you've got a positive number.
 */
public class SafeSquareRoot {

    public static boolean testVal(int n) {
        return n > 0;
    }

    public static int getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static double getSquareRoot() {
        int input = getInput();

        while(!testVal(input)) {
            System.out.println("You can't get the square root of a negative number silly.");
            System.out.println("Enter a number.");
            input = getInput();
        }
        System.out.println("The square root of " +input+" is " + Math.sqrt(input));
        return Math.sqrt(input);
    }

    public static void main(String[] args) {
        System.out.println("SQUARE ROOT!!");
        System.out.println("Enter a number.");
        getSquareRoot();
    }
}
