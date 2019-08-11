package com.company;

/*Task:
 *
 */
public class Constable extends Character {
    private String jurisdiction;

    public Constable(String name,String jurisdiction, int strength, int health, int stamina, int speed,
                     int attackPower)
    {
        super(name, strength, health, stamina, speed, attackPower);
        this.jurisdiction = jurisdiction;
    }

    public Constable() {

    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

}
