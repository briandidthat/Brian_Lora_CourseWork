package com.company;
import java.util.Scanner;

/*Task:
* Write a program that starts with three "piles" of 3 counters each. Let the player choose piles and remove
* counters until all the piles are empty.Start by placing counters (coins or toothpicks or something) into 3 piles.
* The player picks a pile, then removes one or more counters from that pile. (It's okay to take the whole pile.)
* The player picks a new pile, then removes one or more counters from that pile.
* (It's okay to pick the same pile as before.) Once all piles are empty, the game stops.
* You do not need to check for errors like a wrong pile name, or if someone tries to take more counters
* from the pile than the pile has.
*/
public class BabyNim {

    public static String handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    //arbitrary func
    public static int checkPile(int a , int b) {
        return a + b;
    }

    public static void playGame() {
        int counter1 = 3;
        int counter2 = 3;
        int counter3 = 3;
        int selection;
        String pileChosen;

        System.out.println("Welcome to Baby Nim! Pick a pile to remove from. ");
        System.out.format("A: %d\tB: %d\tC: %d", counter1, counter2, counter3);

        while (counter1 !=0 || counter2 != 0 || counter3 !=0) {
            System.out.format("A: %d\tB: %d\tC: %d \n", counter1, counter2, counter3);
            pileChosen = handleInput();
            selection = Integer.parseInt(handleInput());

            if (pileChosen.equalsIgnoreCase("a")) {
                counter1 = (counter1 - selection);
            } else if (pileChosen.equalsIgnoreCase("b")) {
                counter2 = (counter2 - selection);
            } else if (pileChosen.equalsIgnoreCase("c")) {
                counter3 = (counter3 - selection);
            } else {
                System.out.println("Choose an actual pile");
            }
        }
    }

    public static void main(String[] args) {
        playGame();
        System.out.println("GAME OVER!");
    }
}
