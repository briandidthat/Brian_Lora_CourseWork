package com.company;

/**Task:
 * Your code must declare the following array [1, 2, 3, 4, 5], create another array of equal
 * length, and fill that array with values from the original array but in reverse order.
 * Finally, your code must print the contents of both arrays to the screen.
 * -- Instructions did not say to create Methods --
 * so functionality will reside in MAIN method.
 */

public class ArrayFunReverseIt {

    public static void main(String[] args) {
        // Because the elements of array are predefined, I can use an array literal. We also know the size is 5
        int[] initialArr = new int[]{1, 2, 3, 4, 5};
        int j = 5;
        // Define a new array that will accept the new values, and initialize it to the size of the initial arr
        int[] reverseArr = new int[j];

        for (int i = 0; i < initialArr.length; i++) {
            reverseArr[j-1] = initialArr[i];
            j = j - 1;
        }

        System.out.println("Array--Reversed");
        for (int k = 0; k < reverseArr.length; k++) {
            System.out.println("   " + initialArr[k] + "------" + reverseArr[k]);
        }
    }
}
