/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

public class Soldier extends Survivor{
    public Soldier(int id, Weapon weapon) {

        super(100, 10, "Soldier", id, weapon);
    }
    @Override
    public String toString() {
        return String.format("Soldier{id=%d, weapon=%s}", getId(), getWeapon());
    }
}
