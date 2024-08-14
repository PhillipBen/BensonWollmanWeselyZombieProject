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
    protected Weapon weapon;
    public Survivor(double health, double attack, String type, int id, Weapon weapon) {
        super(health, attack, type, id);
        this.weapon = weapon;
    }
    @Override
    public void attack_enemy(Character enemy) {
        Random rand = new Random();
        if (rand.nextDouble() <= weapon.getAccuracy()) {
            enemy.take_damage(weapon.getDamage());
            //System.out.println(type + " " + id + " hit " + enemy.getType() + " " + enemy.getId() + " with " + weapon.getName() + " for " + weapon.getDamage() + " damage.");
        } else {
            enemy.take_damage(0);
            //System.out.println(type + " " + id + " missed " + enemy.getType() + " " + enemy.getId() + " with " + weapon.getName() + ".");
        }
    }
    @Override
    public void take_damage(int damage) {
        health -= damage;
    }

    @Override
    public void death_statement(Character attacker) {
        if (attacker instanceof Zombie) {
            System.out.println(this.getType() + " " + this.getId() + " killed " + attacker.getType() + " " + attacker.getId() + " with " + weapon.getName());
        }
    }
}
