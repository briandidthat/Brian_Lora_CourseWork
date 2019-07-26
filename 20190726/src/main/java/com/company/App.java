package com.company;

public class App {

    public static int subtract(int a, int b) {
        System.out.println(a - b);
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        int c = a-b;

        if (c < 0) {
            c = 0;
        }

        System.out.println(c);
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

        System.out.println(largest);
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

        System.out.println(smallest);
        return smallest;
    }

    public static boolean isLarger(int a, int b) {
        boolean isGreater = false;

        if ( a > b) {
            isGreater = true;
        }

        System.out.println(isGreater);
        return isGreater;
    }

    public static void main(String[] args) {
        subtract(-3, 4);
        subtractOrZero(-2, 15);
        max(17, 13, 8);
        min(12, 22, 41);
        isLarger(7, 12);
    }
}
