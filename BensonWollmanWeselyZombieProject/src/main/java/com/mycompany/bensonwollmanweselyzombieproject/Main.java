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

        /*
        //Initialize Humans
        Scientist human1 = new Scientist();
        
        //Initialize Zombies
        CommonInfected zombie1 = new CommonInfected();
        
        //Start Fight
        human1.attack_enemy(zombie1);
        zombie1.attack_enemy(human1);
         */


        /**
         * Generate number of each unit and display to user
         */
        int numberOfHumans = (int)((Math.random() * 10) + 1);
        int numberOfZombies = (int)((Math.random() * 10) + 1);

        if (numberOfHumans > 1) {
            System.out.println("We have " + numberOfHumans + " survivors trying to make it to safety.");
        } else {
            System.out.println("We have " + numberOfHumans + " survivor trying to make it to safety.");
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
        for (int x = 0; x < numberOfZombies; x++) {
            zombieArrayList.add(new Zombie());
        }

        ArrayList<Survivor> survivorArrayList = new ArrayList<>();
        for (int x = 0; x < numberOfHumans; x++) {
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
                    if (zombieArrayList.get(y).health < 1) {
                        zombieArrayList.remove(y);
                        //System.out.println("Zombie " + y + " has been defeated");
                    }
                }
            }
            /**
             * Zombies attack, remove defeated survivors from survivorArrayList
             */
            for (int x = 0; x < zombieArrayList.size(); x++) {
                for (int y = 0; y < survivorArrayList.size(); y++) {
                    zombieArrayList.get(x).attack_enemy(survivorArrayList.get(y));
                    if (survivorArrayList.get(y).health < 1) {
                        survivorArrayList.remove(y);
                        //System.out.println("Survivor " + y + " has been defeated");
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
