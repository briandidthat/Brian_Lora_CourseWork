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
        // a,b and c are piles. p1 and p2 are players. cp is current player.
        int a, b, c; a = b = c = 3; String p1 = "", p2 = "", cp = "";

        //player name input
        System.out.print("Welcome to Nim!\nEnter Player Names.\nPlayer 1: ");
        p1 = handleInput();
        System.out.print("\nPlayer 2: ");
        p2 = handleInput();
        cp = p1;

        while (a > 0 || b > 0 || c > 0) {
            //pileChoice - the pile that the user chooses. nChoice - amount the user wants to take away.
            // pileAmount - amount in chosen pile.
            char pileChoice = 'z'; int nChoice = -1, pileAmount = 0;

            int atemp = a + 1, btemp = b + 1, ctemp = c + 1;
            int mod = 4;
            while ( mod > 1) {
                if ((atemp % mod) == 0) {
                    System.out.print("\n\t*");
                    atemp --;
                } else {
                    System.out.print("\n\t ");
                }
                if ((btemp % mod) == 0) {
                    System.out.print("*");
                    btemp --;
                } else {
                    System.out.print(" ");
                }
                if ((ctemp % mod) == 0) {
                    System.out.print("*");
                    ctemp --;
                } else {
                    System.out.print(" ");
                }
                mod --;
            }
            System.out.print("\n\tABC");

            //change current player
            if (cp.equals(p1)) {
                cp = p2;
                System.out.print("\n\n" + p2 + ", pick a pile: ");
            } else {
                cp = p1;
                System.out.print("\n\n" + p1 + ", Pick a pile: ");
            }

            //Handles input for pile choice
            while (pileChoice != 'a' && pileChoice != 'b' && pileChoice != 'c')
            {
                String temp = handleInput(); temp = temp.toLowerCase(); ;pileChoice = temp.charAt(0);
                if (pileChoice != 'a' && pileChoice != 'b' && pileChoice != 'c') {
                    System.out.print("invalid input, try again: ");
                }
                switch (pileChoice) {
                    case 'a': if (a == 0) {
                        pileChoice = 'z'; System.out.print("Nice try " + cp + ". Try again: ");
                        break;
                    } else {
                        pileAmount = a;
                        break;
                    }
                    case 'b': if (b == 0) {
                        pileChoice = 'z'; System.out.print("Nice try " + cp + ". Try again: ");
                        break;
                    } else {
                        pileAmount = b; break;
                    }
                    case 'c': if (c == 0) {
                        pileChoice = 'z'; System.out.print("Nice try " + cp + ". Try again: ");
                        break;
                    } else {
                        pileAmount = c;
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + pileChoice);
                }
            }

            //Handles input for the amount you want to take away (nChoice)
            while (nChoice > pileAmount || nChoice <= 0) {
                System.out.print("How any counters do you want to take away from pile " + pileChoice + " ? ");
                nChoice = Integer.parseInt(handleInput());

                if (nChoice > pileAmount) {
                    System.out.println("\nThere aren't even " + nChoice + " counters in " + "pile " + pileChoice);
                }
                if (nChoice <= 0) {
                    System.out.println("\nYou need to choose at least 1. How many? ");
                }
            }

            //processes move
            switch (pileChoice) {
                case 'a':
                    a -= nChoice;
                    break;
                case 'b':
                    b -= nChoice;
                    break;
                case 'c':
                    c -= nChoice;
                    break;
            }

            //checks for win
            if ( a == 0 && b == 0 && c == 1 || a == 0 && b == 1 && c == 0 || a == 1 && b == 0 && c == 0 ) {
                if (cp.equals(p1)) {
                    System.out.println("\n" + p2 + " you must take the last remaining counter, so you lose. " +
                            p1 + " wins!");
                }
                if (cp.equals(p2)) {
                    System.out.println("\n" + p1 + " you must take the last remaining counter, so you lose. " +
                            p2 + " wins!");
                }
                a = b = c = 0;
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
