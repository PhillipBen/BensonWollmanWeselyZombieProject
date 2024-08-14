package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.Random;

public class Weapon {
    private String name;
    private int damage;
    private double accuracy;

    public Weapon(String name, int damage, double accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public boolean hitTarget() {
        Random rand = new Random();
        return rand.nextDouble() <= accuracy;
    }
}

