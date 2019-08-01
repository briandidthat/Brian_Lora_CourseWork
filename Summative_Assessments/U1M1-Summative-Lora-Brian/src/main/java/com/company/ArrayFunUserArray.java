package com.company;
import java.util.Arrays;
import java.util.Scanner;



/**Task: ArrayFun5Words
 * Your code must read 5 ints from the user, put them in an array,
 * and print the array elements to the screen.
 * -- Instructions did not say to create Methods --
 * so functionality will reside in MAIN method.
 */

public class ArrayFunUserArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] nums = new int[5];

        for (int i=0; i < nums.length; i++) {
            System.out.println("Please enter a number.");
            int input = in.nextInt();

            nums[i] = input;
        }

        /*
         While this method can be a bit "hacky", I didn't want to create another for loop if
         I didn't absolutely have to. Blame my ocd, sorry.
         */
        String vals = Arrays.toString(nums);
        System.out.println(vals.replace("[", "").replace("]", ""));
    }
}
