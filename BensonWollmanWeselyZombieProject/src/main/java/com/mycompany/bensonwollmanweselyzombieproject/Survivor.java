/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.Random;

/**
 *
 * @author Phillip
 */
public class Survivor extends Character{
    Weapon survivorWeapon = new Weapon();

    public Survivor(double health, double attack, String type, int id) {
        super(health, attack, type, id);
    }
    public Survivor(int id) {
        super(75, 10, "Survivor", id);
    }

    /**
     *   Randomly generates a value between 1 and 100 and compares random value to accuracy of weapon.
     *   If random value is <= accuracy, it is a hit and attack value is returned
     */
    public double calc_dmg() {
        double damage;
        Random randGen = new Random();
        int hitCalc = randGen.nextInt(1,100);
        if (hitCalc > this.survivorWeapon.accuracy) {
            damage = 0;  // Missed attack
        } else {
            damage = this.survivorWeapon.attack;
        }
        return damage;
    }
}