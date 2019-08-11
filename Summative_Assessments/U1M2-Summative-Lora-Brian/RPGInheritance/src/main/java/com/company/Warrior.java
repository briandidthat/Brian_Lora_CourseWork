package com.company;

/*Task:
 *
 */
public class Warrior extends Character {
    private int shieldStrength;

    public Warrior(String name, int shieldStrength,int strength, int health, int stamina, int speed,
                   int attackPower)
    {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
    }

    public Warrior() {

    }

}
