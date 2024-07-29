/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

/**
 *
 * @author Phillip
 */
public class Character {
    /*
    * ints will work but opted for double if/when future versions of the game have more
    * complex attacking sitations where you'll need more granularity into health.
    */
    protected double health;
    protected double attack;
    
    public Character(double health, double attack) {
        this.health = health;
        this.attack = attack;
    }

    public Character() {
        this.health = 100;
        this.attack = 10;
    }
    
    /**
    * Check answer.
    * @param enemy Character: The enemy that is being attacked.
    */
    public void attack_enemy(Character enemy) {
        enemy.take_damage(attack);
    }
    
    /**
    * Check answer.
    * @param damage Double: The amount of damage being done.
    */
    public void take_damage(double damage) {
        this.health -= damage;
        System.out.println(get_entity() + " took " + damage + " damage.");
    }
    
    /**
    * Check answer.
    * @return True if health is greater than 0.
    */
    public boolean is_alive() {
        return this.health > 0;
    }
    
    
    /**
    * Check answer.
    * @return String: Returns the entity type of this instance.
    */
    public String get_entity() {
        if(this instanceof Zombie) {
            return "Zombie";
        }else if(this instanceof Survivor) {
            return "Survivor";
        }else {
            return "NULL";
        }
    }
}
