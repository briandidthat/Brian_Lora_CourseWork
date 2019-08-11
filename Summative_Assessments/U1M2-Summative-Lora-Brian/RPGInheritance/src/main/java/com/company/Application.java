package com.company;

/*Task:
 * Test derived classes values
 */
public class Application {

    public static void main(String[] args) {
        Constable constable = new Constable();
        Farmer farmer = new Farmer();
        Warrior warrior = new Warrior();

        constable.setName("Constantine");
        constable.setHealth(200);
        constable.setSpeed(100);
        constable.setStamina(150);
        constable.setStrength(500);
        constable.setAttackPower(12);

        farmer.setName("Farmy Joe");
        farmer.setHealth(200);
        farmer.setSpeed(100);
        farmer.setStamina(150);
        farmer.setStrength(500);
        farmer.setAttackPower(8);

        warrior.setName("Guerrero");
        warrior.setHealth(200);
        warrior.setSpeed(100);
        warrior.setStamina(150);
        warrior.setStrength(500);
        warrior.setAttackPower(15);

        System.out.println(warrior.getAttackPower());
        System.out.println(farmer.getAttackPower());
        System.out.println(constable.getAttackPower());

        System.out.println(constable);
        System.out.println(farmer);
        System.out.println(warrior);
    }
}
