package com.company;
import java.util.Arrays;
import java.util.Scanner;

/**Task: ArrayFun5Words
 * Your code must get 5 words from the user, put them in an array,
 * and print the array elements to the screen.
 * -- Instructions did not say to create Methods --
 * so functionality will reside in MAIN method.
 */

public class ArrayFun5Words {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] words = new String[5];

        for (int i=0; i < words.length; i++) {
            System.out.println("Please enter a word.");
            String input = in.nextLine();

            words[i] = input;
        }

        /*
         While this method can be a bit "hacky", I didn't want to create another for loop if
         I didn't ABSOLUTELY have to, and the array already brought the commas for me. Blame my ocd, sorry.
         */
        String vals = Arrays.toString(words);
        System.out.println(vals.replace("[", "").replace("]", ""));
    }
}
