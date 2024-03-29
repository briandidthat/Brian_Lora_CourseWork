package com.company;

/* Create the following methods:
 * Total
 * TotalOdd
 * TotalEven
 * SecondLargest
 * SwapFirstAndLast
 * Reverse
 * ConcatenateString
 * LessThanFive
 * EveryThird
 */

public class App {

    // return the sum of all the values in an array of ints. (enhanced for loop)
    public static int total(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }

    // return the sum of only the values of the odd numbered indexes in an array of ints.
    public static int totalOdd(int[] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            if ( i % 2 != 0) {
                val += arr[i];
            }
        }
        return val;
    }

    // return the sum of only the values of the even numbered indexes in an array of ints.
    public static int totalEven(int[] arr) {
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                val += arr[i];
            }
        }
        return val;
    }

    // return the second largest number in an array of ints.
    public static int secondLargestNumber(int[] arr) {
        int largest = Integer.MIN_VALUE; // initializing largest && secondLargest to min values possible
        int secondLargest = Integer.MIN_VALUE;

        for (int i =0; i< arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    // swap the first and last elements, and return the array.
    public static String[] swapFirstAndLast(String[] arr) {

        String first = arr[0];
        String last = arr[arr.length -1];

        arr[0] = last;
        arr[arr.length -1] = first;

        return arr;
    }

    // return a new array with the array reversed.
    public static int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        int j = arr.length;

        for (int i = 0; i < arr.length; i++ ) {
            reversedArray[j-1] = arr[i];
            j -= 1;
        }

        return reversedArray;
    }

    // return a String which consists of the concatenation of all elements in the array.
    public static String concatenateString(String[] arr) {
        String val = "";

        for (int i =0; i < arr.length; i++) {
            val += arr[i];
        }

        return val;
    }


    // find the elements that are less than five, and return an array containing those elements.
    public static int[] lessThanFive(int[] arr) {
        int counter = 0;

        for (int i = 0; i <arr.length; i++) {
            if(arr[i] < 5) {
                counter++;
            }
        }

        // if there are no elements less than 5, return null.
        if (counter == 0) {
            return null;
        } else {

            int[] newArray = new int[counter];

            for (int j = 0; j < newArray.length; j++) {
                if (arr[j] < 5) {
                    newArray[j] = arr[j];
                }
            }
            return newArray;
        }
    }

    // return an array which consists of every third element.
    public static int[] everyThird(int[] arr) {

        if (arr.length < 3) {
            return null;
        } else {
            // define counter, as I must find out how many elements my new array should have. i += 3;
            int counter = 0;
            for (int i=2; i < arr.length; i+=3) {
                counter += 1;
            }
            // array index to mitigate index bug on new array. array++;
            int arrIdx = 0;
            int[] thirdsArray = new int[counter];

            for (int j=2; j < arr.length; j+=3) {
                thirdsArray[arrIdx] = arr[j];
                arrIdx++;
            }

            return thirdsArray;
        }
    }

    // Extra challenges
    public static int[] splitAtFive(int[] arr) {
        int[] splitArray = new int[arr.length];


        return splitArray;
    }

    public static int[] evensAndOdds(int[] arr) {
        int[] evensOddsArray = new int[arr.length];

        return evensOddsArray;
    }

    public static void main(String[] args) {
       int[] arr = {0,1,2,3,33};
       lessThanFive(arr);
    }
}
