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
            j = j-1;
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

    // return an array which consists of every third element.
    public static int[] everyThird(int[] arr) {

        if (arr.length < 3) {
            return null;
        } else {
            // define counter, as I must find out how many elements my new array should have. i += 3
            int counter = 0;
            for (int i =0; i < arr.length; i+=3) {
                counter += 1;
            }

            int[] thirdsArray = new int[counter];

            for (int j=1; j < counter; j+=3) {
                thirdsArray[j] = arr[j];
            }

            return thirdsArray;
        }
    }

    // find the elements that are less than five, and return an array containing those elements.
    public static int[] lessThanFive(int[] arr) {
        int counter = 0;

        for (int i =0; i < arr.length; i++) {
            if(arr[i] < 5) {
                counter += 1;
            }
        }
        // if there are no elements less than 5, return null.
        if (counter == 0) {
            return null;
        }

        int[] newArray = new int[counter];
        System.out.println(newArray.length);

        for (int j =0; j < counter; j++) {
            if(arr[j] < 5) {
                newArray[j] = arr[j];
            }
        }

        return newArray;
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
       everyThird(arr);
    }
}
