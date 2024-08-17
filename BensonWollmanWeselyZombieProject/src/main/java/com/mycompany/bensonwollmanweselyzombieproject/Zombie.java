/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

/**
 *
 * @author Phillip
 */
public class Zombie extends Character{
    public Zombie(double health, double attack, String type, int id) {
        super(health, attack, type, id);
    }
    public Zombie(int id) {
        super(75, 10, "Zombie", id);
    }
    @Override
    public void attack_enemy(Character enemy) {
        enemy.take_damage(this.attack);
        System.out.println(type + " " + id + " hit " + enemy.getType() + " " + enemy.getId() + " for " + this.attack + " damage.");
    }
}
