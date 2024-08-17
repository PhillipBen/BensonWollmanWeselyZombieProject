package com.mycompany.bensonwollmanweselyzombieproject;

class Weapon {
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
    public double getDamage() {
        return damage;
    }
    public double getAccuracy() {
        return accuracy;
    }

    /*
     * This was originally used for testing battle logic with output, but that has
     * been taken out for a more polished v3 release.
     */
    @Override
    public String toString() {
        return String.format("Weapon{name='%s', damage=%d, accuracy=%.2f}", name, damage, accuracy);
    }
}