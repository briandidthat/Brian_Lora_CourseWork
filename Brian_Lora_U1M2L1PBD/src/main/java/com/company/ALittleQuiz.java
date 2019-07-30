package com.company;
import java.util.Scanner;

/*Task:
 * Write an interactive quiz. It should ask the user three multiple-choice or true/false questions
 * about something. It must keep track of how many they get wrong, and print out a "score" at the end.
 */

public class ALittleQuiz {

    public static void returnVals(String vals) {
        System.out.println(vals);
    }

    public static void checkAnswers() {
        Scanner in = new Scanner(System.in);
        String[] questions = {"Was the 45th president of the United States Barack Obama?", "Is pluto a planet?",
                "Are kangaroos mammals?"};
        String choices = "1: true      2: false";
        int[] answers = {1, 2, 1};

        int answer;
        int counter = 0;
        // loop over the array and ask the questions
        for (int i =0; i < questions.length; i++) {
            returnVals(questions[i]);
            returnVals(choices);

            answer = in.nextInt();
            // if answer is correct, update counter
            if ( answer == answers[i]) {
                counter += 1;
            } else if (answer < 1 || answer > 2 ) {
                returnVals("Sorry, you've entered an incorrect value. Try again");
                answer = in.nextInt();
            }
        }
        System.out.println("Overall, you got " + counter+ " of 3 correct.");
    }

    public static void main(String[] args) {
        checkAnswers();
    }
}
