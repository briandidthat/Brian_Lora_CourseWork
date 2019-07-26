package com.company;

/**Task:
 * Total
 * TotalOdd
 * TotalEven
 * SecondLargest
 * SwapFirstAndLast
 * Reverse
 */

public class App {

    public static int total(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }


    public static int totalOdd(int[] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            if ( i % 2 != 0) {
                val += arr[i];
            }
        }
        return val;
    }

    public static int totalEven(int[] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                val += arr[i];
            }
        }
        return val;
    }

    public static int secondLargestNumber(int[] arr) {
        int largest = 0;
        int second = 0;

        for (int i = 0; i < arr.length; i++ ) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        return second;
    }

    public static String[] swapFirstAndLast(String[] arr) {

        String first = arr[0];
        String last = arr[arr.length -1];

        arr[0] = last;
        arr[arr.length -1] = first;

        return arr;
    }

    public static int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        int j = arr.length;

        for (int i = 0; i < arr.length; i++ ) {
            reversedArray[j-1] = arr[i];
            j = j-1;
        }

        return reversedArray;
    }

    public static String concatenateString(String[] arr) {
        String val = "";

        for (int i =0; i < arr.length; i++) {
            val += arr[i];
        }

        return val;
    }

    public static int[] lessThanFive(int[] arr) {
        int[] newArray = new int[arr.length];

        for (int i =0; i> arr.length; i++) {
            if(arr[i] < 5) {
                newArray[i] = arr[i];
            }
        }

        if (newArray.length != 0) {
            return newArray;
        } else {
            return null;
        }
    }



    public static void main(String[] args) {



    }
}
