package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.Random;

public class Survivor extends Character{
    protected Weapon weapon;
    // Added a weapon into the constructor, gives us easier access to name and damage.
    public Survivor(double health, double attack, String type, int id, Weapon weapon) {
        super(health, attack, type, id);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    /*
     *  Random produces value 0.0 (inclusive) to 1.0 (exclusive), this works because none
     *  of our weapons have an accuracy above 0.95. Overrides superclass because character does not have
     *  access to weapon info which we need for output requirements.
     */
    @Override
    public void attack_enemy(Character enemy) {
        Random rand = new Random();
        if (rand.nextDouble() <= weapon.getAccuracy()) {
            enemy.take_damage(weapon.getDamage());
        }
    }
}