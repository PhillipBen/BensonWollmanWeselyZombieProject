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
    Weapon weapon = new Weapon();

    public Survivor(double health, double attack, String type, int id) {
        super(health, attack, type, id);
    }
    public Survivor(int id) {
        super(75, 10, "Survivor", id);
    }

    @Override
    public void attack_enemy(Character enemy) {
        Random rand = new Random();
        if (rand.nextDouble() <= weapon.getAccuracy()) {
            enemy.take_damage(weapon.getDamage()); 
        } else {
            enemy.take_damage(0);
        }
    }
    
    @Override
    public void death_statement(Character attacker) {
        if (attacker instanceof Zombie) {
            System.out.println(attacker.getType() + " " + attacker.getId() + " killed " + this.getType() + " " + this.getId());
        }
    }
    
    public Weapon getWeapon() {
        return weapon;
    }
}