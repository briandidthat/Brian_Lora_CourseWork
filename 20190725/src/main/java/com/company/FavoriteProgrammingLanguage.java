package com.company;
import java.util.Scanner;

/**Task:
 * Write a program that continues to ask for the users favorite programming language until they --
 * choose "Java". Once they do, print "Thats what I was looking for! Java is definitely the answer."
 * Will need Scanner (System.in), while loop
 */
public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What's your favorite programming language?");
        String favLanguage = in.nextLine();
        String correctAnswer = "java";

        while (!favLanguage.equalsIgnoreCase(correctAnswer)) {
            System.out.println("C'mon, there's a better language than that, try again.");
            favLanguage = in.nextLine();
        }
        System.out.println("That's what I was looking for! Java is definitely the answer!");
    }
}
