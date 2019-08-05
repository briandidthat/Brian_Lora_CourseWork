package com.company;
import java.util.Scanner;

/*Task:
* Nim is a strategy game between two players.
* Start by placing counters (coins or toothpicks or something) into 3 piles.
* Player #1 picks a pile, then removes one or more counters from that pile. (It's okay to take the whole pile.)
* Player #2 picks a pile, then removes one or more counters from that pile.
* Player #1 plays again. (It's okay to choose a different pile this time.)
* Whichever player is forced to take the last counter is the LOSER.
* Write a program that allows two human players to play Nim against each other.
* The program should detect when the last counter has been taken and declare a winner.
*/
public class Nim {

    public static String handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void playGame() {
        int counter1 = 3;
        int counter2 = 3;
        int counter3 = 3;
        int selection;
        String pileChosen;

        System.out.println("Welcome to Baby Nim! Pick a pile to remove from. ");


        while (counter1 !=0 || counter2 != 0 || counter3 !=0) {
            System.out.format("A: %d\tB: %d\tC: %d \n", counter1, counter2, counter3);
            pileChosen = handleInput();
            System.out.println("How much would you like to remove?");
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
        System.out.format("A: %d\tB: %d\tC: %d \n", counter1, counter2, counter3);
        System.out.println("GAME OVER!");
    }


    public static void main(String[] args) {
        playGame();
    }

}
