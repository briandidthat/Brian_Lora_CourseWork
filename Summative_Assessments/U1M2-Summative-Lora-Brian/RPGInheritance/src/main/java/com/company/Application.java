package com.company;

/*Task:
 * Test derived classes values
 */
public class Application {

    public static void main(String[] args) {
        Constable constable = new Constable("Constantine","Mesopotamia", 60, 100, 60,20, 5);
        Farmer farmer = new Farmer("Farmy Joe", 75, 100, 75, 10, 1);
        Warrior warrior = new Warrior("Tray", 100, 75, 100, 100, 50, 10);

        System.out.println(constable.getName());
        System.out.println(farmer.getName());
        System.out.println(warrior.getName());

        System.out.println(warrior.getAttackPower());
        System.out.println(farmer.getAttackPower());
        System.out.println(constable.getAttackPower());

        System.out.println(constable.getStamina());
        System.out.println(farmer.getStamina());
        System.out.println(warrior.getStamina());

    }
}
