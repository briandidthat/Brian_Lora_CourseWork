package com.company;

public abstract class Character {
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    public Character(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    public Character() {

    }

    public abstract void run(int distance);
    public abstract void heal();
    public abstract void decreaseHealth(int num);
    public abstract void increaseStamina(int num);
    public abstract void decreaseStamina(int num);
    public abstract void attack();
}
