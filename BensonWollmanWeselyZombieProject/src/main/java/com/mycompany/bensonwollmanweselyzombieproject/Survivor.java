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
    public Survivor(double health, double attack, String type, int id) {
        super(health, attack, type, id);
    }
    public Survivor(int id) {
        super(75, 10, "Survivor", id);
    }

}
