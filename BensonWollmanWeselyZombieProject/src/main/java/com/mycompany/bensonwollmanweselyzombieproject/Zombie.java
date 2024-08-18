package com.mycompany.bensonwollmanweselyzombieproject;

public class Zombie extends Character{
    public Zombie(double health, double attack, String type, int id) {
        super(health, attack, type, id);
    }
    public Zombie(int id) {
        super(75, 10, "Zombie", id);
    }
    /*
     * Created so that we could have an attack_enemy where access to weapon
     * information wasn't needed.
     */
    @Override
    public void attack_enemy(Character enemy) {
        enemy.take_damage(this.attack);
    }
}
