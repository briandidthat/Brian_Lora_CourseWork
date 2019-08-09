package com.company;

/*Task:
 *
 */
public class Constable extends Character {
    private String jurisdiction;

    public Constable(String name, int strength, int health, int stamina, int speed,
                     int attackPower, String jurisdiction)
    {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
    }

    public Constable() {

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
