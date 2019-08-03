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

    public static int handleInput() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void main(String[] args) {

    }

}
