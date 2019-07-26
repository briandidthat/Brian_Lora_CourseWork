package com.company;

/** Task
 * Create the following five methods
 * subtract (two params of type int - a, b) subtract b from a and return val
 * subtractOrZero (two params of type int - a, b) if c < 0, return 0
 * max (three params of type int, a, b ,c) return largest
 * min (three params of type int, a, b ,c) return smallest
 */

public class App {

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int c = a - b;

        if (c < 0) {
            c = 0;
        }

        return c;
    }

    public static int max(int a, int b, int c) {
        int largest;

        if (a > c && a > b) {
            largest = a;
        } else if (c > a && c > b) {
            largest = c;
        } else {
            largest = b;
        }

        return largest;
    }

    public static int min(int a, int b, int c) {
        int smallest;

        if (a < c && a < b) {
            smallest = a;
        } else if (c < a && c < b) {
            smallest = c;
        } else {
            smallest = b;
        }

        return smallest;
    }

    public static boolean isLarger(int a, int b) {
        boolean isGreater = false;

        if ( a > b) {
            isGreater = true;
        }

        return isGreater;
    }

    public static void main(String[] args) {
        System.out.println(subtract(-3, 4));
        System.out.println(subtractOrZero(-2, 15));
        System.out.println(max(17, 13, 8));
        System.out.println(min(12, 22, 41));
        System.out.println(isLarger(7, 12));
    }
}
