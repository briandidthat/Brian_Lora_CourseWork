package com.company;

/*Task:
 *Write a program that uses a for loop to display all the numbers from 1 to 20, marking those which are
 * even (divisible by two). It should use modulus by 2: if the remainder is zero, it's divisible by 2.
 * This means you'll need an if statement inside the loop.
 */
public class NoticingEvenNumbers {
    public static void checkEven() {
        for (int i =0; i < 21; i++) {
            if(i % 2 == 0) {
                System.out.println(i + " *******");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        checkEven();
    }
}
