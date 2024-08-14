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

    @Override
    public void take_damage(int damage) {
        health -= damage;
    }
    @Override
    public void death_statement(Character attacker) {
        if (attacker instanceof Survivor) {
            System.out.println(this.getType() + " " + this.getId() + " killed " + attacker.getType() + " " + attacker.getId());
        }
    }
    public Zombie(int id) {
        super(75, 10, "Zombie", id);
    }
}
