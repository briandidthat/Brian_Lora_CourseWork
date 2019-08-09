package com.company;

/*Task:
 *
 */
public class Warrior extends Character {
    private int shieldStrength;

    public Warrior(int shieldStrength, String name, int strength, int health, int stamina, int speed,
                   int attackPower)
    {
        super(name, strength, health, stamina, speed, attackPower);
        this.shieldStrength = shieldStrength;
    }

    public Warrior() {
        super();
    }

    @Override
    public void run(int distance) {

    }

    @Override
    public void heal() {

    }

    @Override
    public void decreaseHealth(int num) {

    }

    @Override
    public void increaseStamina(int num) {

    }

    @Override
    public void decreaseStamina(int num) {

    }

    @Override
    public void attack() {

    }

}
