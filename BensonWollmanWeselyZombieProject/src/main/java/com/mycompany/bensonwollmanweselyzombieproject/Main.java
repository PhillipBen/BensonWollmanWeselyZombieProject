/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;

/**
 *
 * @author Phillip Chris Dustin
 *
 * Netbeans: View Function tooltips with Control + Shift + Space.
 */
public class Main {
    
    public static void main() {
        /**
         * Generate number of each unit and display to user
         */
        int numberOfSurvivors = (int)((Math.random() * 10) + 1);
        int numberOfZombies = (int)((Math.random() * 10) + 1);

        if (numberOfSurvivors > 1) {
            System.out.println("We have " + numberOfSurvivors + " survivors trying to make it to safety.");
        } else {
            System.out.println("We have " + numberOfSurvivors + " survivor trying to make it to safety.");
        }
        if (numberOfZombies > 1) {
            System.out.println("But there are " + numberOfZombies + " zombies waiting for them.");
        } else {
            System.out.println("But there is " + numberOfZombies + " zombie waiting for them.");
        }
        /**
         * Create ArrayList for each unit type then generate unit objects for each type each unit type and add to it's
         * respective ArrayList
         */
        ArrayList<Zombie> zombieArrayList = new ArrayList<>();
        for (int y = 0; y < numberOfZombies; y++) {
            zombieArrayList.add(new Zombie());
        }

        ArrayList<Survivor> survivorArrayList = new ArrayList<>();
        for (int x = 0; x < numberOfSurvivors; x++) {
            survivorArrayList.add(new Survivor());
        }
        /**
         * Battle
         */
        while (!zombieArrayList.isEmpty() && !survivorArrayList.isEmpty()) {
            /**
             * Survivors attack, remove defeated zombies from zombieArrayList
             */
            for (int x = 0; x < survivorArrayList.size(); x++) {
                for (int y = 0; y < zombieArrayList.size(); y++) {
                    survivorArrayList.get(x).attack_enemy(zombieArrayList.get(y));
                    if (!zombieArrayList.get(y).is_alive()) {
                        zombieArrayList.remove(y);
                    }
                }
            }
            /**
             * Zombies attack, remove defeated survivors from survivorArrayList
             */
            for (int y = 0; y < zombieArrayList.size(); y++) {
                for (int x = 0; x < survivorArrayList.size(); x++) {
                    zombieArrayList.get(y).attack_enemy(survivorArrayList.get(x));
                    if (!survivorArrayList.get(x).is_alive()) {
                        survivorArrayList.remove(x);
                    }
                }
            }
        }
        if (survivorArrayList.isEmpty()) {
            System.out.println("All survivors parished");
        } else {
            System.out.println("It seems " + survivorArrayList.size() + " made it to safety.");
        }
    }
}
