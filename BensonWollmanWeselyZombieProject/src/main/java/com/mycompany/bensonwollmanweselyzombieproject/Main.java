package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

import static com.mycompany.bensonwollmanweselyzombieproject.WeaponCache.generateWeapons;

public class Main {
    public static void main() {
        /*
         * New Spawning System:
         * Create the survivor and zombie array lists, add 1-3 of each listed class to each array, 
         * respective of their super class, with ID's increasing in respect to their specific class (Zombie or Survivor)
         */
        Random randGen = new Random();
        ArrayList<Survivor> survivorArrayList = new ArrayList<>();
        ArrayList<Zombie> zombieArrayList = new ArrayList<>();

        // Created an upper bound as to easily toggle the maximum for survivors and zombies
        int upperBound = 4;
        
        //Simply for the initial print statements
        int numScientist = randGen.nextInt(1,upperBound);
        int numCivilian = randGen.nextInt(1,upperBound);
        int numSoldier = randGen.nextInt(1,upperBound);
        int survivorTotal = numCivilian + numSoldier + numScientist;

        Weapon[] weapons = generateWeapons(survivorTotal);
        
        int numCommonInfected = randGen.nextInt(1,upperBound);
        int numTank = randGen.nextInt(1,upperBound);

        // weaponCount is used as a tracking variable as we loop through the array of weapon objects
        int weaponCount = 0;

        //Survivors: Scientist, Civilian, Soldier
        for(int i = 0; i < numScientist; i++) {
            Weapon weapon = weapons[weaponCount++];
            survivorArrayList.add(new Scientist(i, weapon));
        }
        for(int i = 0; i < numCivilian; i++) {
            Weapon weapon = weapons[weaponCount++];
            survivorArrayList.add(new Civilian(i, weapon));
        }
        for(int i = 0; i < numSoldier; i++) {
            Weapon weapon = weapons[weaponCount++];
            survivorArrayList.add(new Soldier(i, weapon));
        }
        
        //Zombies: CommonInfected, Tank
        for(int i = 0; i < numCommonInfected; i++) {
            zombieArrayList.add(new CommonInfected(i));
        }
        for(int i = 0; i < numTank; i++) {
            zombieArrayList.add(new Tank(i));
        }

        /*
         * Initial print statements displaying number of survivors and zombies to the user.
         */

        System.out.println("We have " + survivorArrayList.size() + " survivors trying to make it to safety (" + numScientist + " scientist, " + numCivilian + " civilian, " + numSoldier + " soldiers)");
        System.out.println("But there are " + zombieArrayList.size() + " zombies waiting for them (" + numCommonInfected + " common infected, " + numTank + " tanks)");

        /*
         * Battle
         */
        while (!zombieArrayList.isEmpty() && !survivorArrayList.isEmpty()) {
            /*
             * Survivors attack, remove defeated zombies from zombieArrayList.
             * We decided to use an Iterator. Using this allows us to remove a dead zombie. Before when
             * we were using an arraylist.remove, we were seeing characters disappear. We suspect this is
             * because we were removing from the front of the list, and everything beyond was shifting left.
             */
            for (Survivor survivor : survivorArrayList) {
                Iterator<Zombie> zombieIterator = zombieArrayList.iterator();
                while (zombieIterator.hasNext()) {
                    Zombie zombie = zombieIterator.next();
                    survivor.attack_enemy(zombie);
                    if (!zombie.is_alive()) {
                        zombie.death_statement(survivor);
                        zombieIterator.remove();
                    }
                }
            }
            /*
             * Zombies attack, remove defeated survivors from survivorArrayList
             */
            for (Zombie zombie : zombieArrayList) {
                Iterator<Survivor> survivorIterator = survivorArrayList.iterator();
                while (survivorIterator.hasNext()) {
                    Survivor survivor = survivorIterator.next();
                    zombie.attack_enemy(survivor);
                    if (!survivor.is_alive()) {
                        survivor.death_statement(zombie);
                        survivorIterator.remove();
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
