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
    public void death_statement(Character attacker) {
        //Source: https://stackoverflow.com/questions/2856122/how-to-find-out-the-subclass-from-the-base-class-instance
        if (attacker instanceof Survivor) {
            System.out.println(attacker.getType() + " " + attacker.getId() + " killed " + this.getType() + " " + this.getId() + " with " + ((Survivor)attacker).getWeapon().getName());
        }
    }
}
