/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Phillip Chris Dustin
 *
 * Netbeans: View Function tooltips with Control + Shift + Space.
 */
public class Main {
    
    public static void main() {
        /**
         * New Spawning System:
         * Create the survivor and zombie array lists, add 1-3 of each listed class to each array, 
         * respective of their super class, with ID's increasing in respect to their specific class (Zombie or Survivor)
         */
        Random randGen = new Random();
        ArrayList<Survivor> survivorArrayList = new ArrayList<>();
        ArrayList<Zombie> zombieArrayList = new ArrayList<>();
        
        //Simply for the initial print statements
        int numScientist = randGen.nextInt(1,4);
        int numCivilian = randGen.nextInt(1,4);
        int numSoldier = randGen.nextInt(1,4);
        
        int numCommonInfected = randGen.nextInt(1,4);
        int numTank = randGen.nextInt(1,4);
        
        //Survivors: Scientist, Civilian, Soldier
        for(int i = 0; i < numScientist; i++) {
            survivorArrayList.add(new Scientist(i));
        }
        for(int i = 0; i < numCivilian; i++) {
            survivorArrayList.add(new Civilian(i));
        }
        for(int i = 0; i < numSoldier; i++) {
            survivorArrayList.add(new Soldier(i));
        }
        
        //Zombies: CommonInfected, Tank
        for(int i = 0; i < numCommonInfected; i++) {
            zombieArrayList.add(new CommonInfected(i));
        }
        for(int i = 0; i < numTank; i++) {
            zombieArrayList.add(new Tank(i));
        }
        
        
        /**
         * Initial print statements displaying number of survivors and zombies to the user.
         */
        System.out.println("We have " + survivorArrayList.size() + " survivors trying to make it to safety (" + numScientist + " scientist, " + numCivilian + " civilian, " + numSoldier + " soldiers)");
        System.out.println("But there are " + zombieArrayList.size() + " zombies waiting for them (" + numCommonInfected + " common infected, " + numTank + " tanks)");
        
        
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
                        zombieArrayList.get(y).death_statement(survivorArrayList.get(x));
                        zombieArrayList.remove(y);
                    }
                }
            }
            /**
             * Zombies attack, remove defeated survivors from survivorArrayList
             */
            for (int x = 0; x < zombieArrayList.size(); x++) {
                for (int y = 0; y < survivorArrayList.size(); y++) {
                    zombieArrayList.get(x).attack_enemy(survivorArrayList.get(y));
                    if (!survivorArrayList.get(y).is_alive()) {
                        survivorArrayList.get(y).death_statement(zombieArrayList.get(x));
                        survivorArrayList.remove(y);
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
