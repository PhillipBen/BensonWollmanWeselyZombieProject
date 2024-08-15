/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

public class Civilian extends Survivor {
    public Civilian(int id, Weapon weapon) {

        super(50, 5, "Civilian", id, weapon);
    }
    @Override
    public String toString() {
        return String.format("Civilian{id=%d, weapon=%s}", getId(), getWeapon());
    }

    private Object getWeapon() {
        return this.weapon;
    }
}