/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;

/**
 *
 * @author Phillip
 * 
 * Netbeans: View Function tooltips with Control + Shift + Space.
 */
public class Main {
    
    public static void main() {
        //Initialize Humans
        Scientist human1 = new Scientist();
        
        //Initialize Zombies
        CommonInfected zombie1 = new CommonInfected();
        
        //Start Fight
        human1.attack_enemy(zombie1);
        zombie1.attack_enemy(human1);
    }
}
