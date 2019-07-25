package com.company;
import java.util.Scanner;

/**Task:
 * Ask the user for input, and ask followup question based on the reply.
 * Will Need Scanner (System.in), if statements
 */

public class AgeAgain {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your age.");
        int age = in.nextInt();


        String grade;
        String collegeAnswer;
        String job;


        if (age < 14) {
            System.out.println("What grade are you in?");
            grade = in.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        } else if (age > 14 && age <= 18 ) {
            System.out.println("Are you planning on going to college?");
            collegeAnswer = in.nextLine();
            if (collegeAnswer.equalsIgnoreCase("yes")) {
                System.out.println(collegeAnswer + " is a great school!");
            } else if (collegeAnswer.equalsIgnoreCase("no")) {
                String noCollege = in.nextLine();
                System.out.println("Wow, sounds like a plan!");
            }
        } else if (age > 18) {
            job = in.nextLine();
            System.out.println(job +" sounds like a great job!");
        } else {

        }

    }
}
