package com.company;
import java.util.Scanner;

/* Task:
 * Write a program to calculate a target weight given the weight and formulas.
 * Ask weight, and planet that he would like to fight on to calculate the weight.
 * weight * relative gravity of chosen planet = target weight
 */

public class SpaceBoxing {

    public static double calculateWeight(int weight, double gravity) {
        return weight * gravity;
    }

    public static void returnVal(double weight) {
        System.out.println("Your weight would be " + weight + " on that planet.");
    }

    public static void checkPlanet() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter your earth weight.");

        int weight = in.nextInt();

        System.out.println("Please select the number that represents the planet you will visit. ");
        System.out.println("1. Venus 2. Mars 3. Jupiter \n4. Saturn 5. Uranus 6. Neptune");
        int planet = in.nextInt();

        switch(planet) {
            case 1:
                returnVal(calculateWeight(weight, 0.78));
                break;
            case 2:
                returnVal(calculateWeight(weight, 0.39));
                break;
            case 3:
                returnVal(calculateWeight(weight, 2.65));
                break;
            case 4:
                returnVal(calculateWeight(weight, 1.17));
                break;
            case 5:
                returnVal(calculateWeight(weight, 1.05));
                break;
            case 6:
                returnVal(calculateWeight(weight, 1.23));
            default:
                break;
        }
    }

    public static void main(String[] args) {
        checkPlanet();
    }
}
