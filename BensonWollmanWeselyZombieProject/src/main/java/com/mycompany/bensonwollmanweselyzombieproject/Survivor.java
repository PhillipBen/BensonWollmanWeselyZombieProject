/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

/**
 *
 * @author Phillip
 */
public class Survivor extends Character{
    private Weapon weapon;

    public Survivor(double health, double attack, String type, int id) {
        super(health, attack, type, id);
        this.weapon = WeaponCache.weapon_select();
    }
    public Survivor(int id) {
        super(75, 10, "Survivor", id);
        this.weapon = WeaponCache.weapon_select();
    }
    public Weapon getWeapon(){
        return weapon;
    }
    @Override
    public void attack_enemy(Character enemy) {
        if (weapon.hitTarget()) {
            double damage = weapon.getDamage();
            enemy.take_damage(damage);
            System.out.println(this.type + " " + this.id + " used " + weapon.getName() + " and dealt " + damage + " damage.");
        } else {
            return;
        }
    }

}
