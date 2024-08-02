/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author Phillip
 * 
 * Netbeans: View Function tooltips with Control + Shift + Space.
 */
public class Main {
    
    public static void main() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of Common Infected zombies: ");
        int numberOfCommonInfected = scanner.nextInt();
        System.out.print("Enter the number of Tank zombies: ");
        int numberOfTanks = scanner.nextInt();

        System.out.print("Enter the number of Civilian survivors: ");
        int numberOfCivilians = scanner.nextInt();
        System.out.print("Enter the number of Scientist survivors: ");
        int numberOfScientists = scanner.nextInt();
        System.out.print("Enter the number of Soldier survivors: ");
        int numberOfSoldiers = scanner.nextInt();

        List<Zombie> zombies = new ArrayList<>();
        List<Survivor> survivors = new ArrayList<>();

        for (int i = 0; i < numberOfCommonInfected; i++) {
            zombies.add(new CommonInfected(i));
        }
        for (int i = 0; i < numberOfTanks; i++) {
            zombies.add(new Tank(i));
        }


        for (int i = 0; i < numberOfSoldiers; i++) {
            survivors.add(new Soldier(i));
        }
        for (int i = 0; i < numberOfScientists; i++) {
            survivors.add(new Scientist(i));
        }
        for (int i = 0; i < numberOfCivilians; i++) {
            survivors.add(new Civilian(i));
        }

        int zombieIndex = 0;
        int survivorIndex = 0;

        while (zombieIndex < zombies.size() && survivorIndex < survivors.size()) {
            Survivor survivor = survivors.get(survivorIndex);
            Zombie zombie = zombies.get(zombieIndex);

            while (zombie.is_alive() && survivor.is_alive()) {
                survivor.attack_enemy(zombie);
                //System.out.println("Zombie health after attack: " + zombie.getHealth());
                if (!zombie.is_alive()) {
                    System.out.println(survivor.getType() + " " + survivor.getId() + " killed " + zombie.getType() + " " + zombie.getId());
                    // System.out.println("Hoorah! Zombie has died!");
                    break;
                }

                zombie.attack_enemy(survivor);
                //System.out.println("Survivor health after attack: " + survivor.getHealth());
                if (!survivor.is_alive()) {
                    System.out.println(zombie.getType() + " " + zombie.getId() + " killed " + survivor.getType() + " " + survivor.getId());
                    //System.out.println("Sad day, rest in peace soldier.");
                    break;
                }
            }

            if (!zombie.is_alive()) {
                zombieIndex++;
            } else if (!survivor.is_alive()) {
                survivorIndex++;
            }
        }
//        if (survivorIndex < survivors.size()) {
//            System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
//            System.out.println("But there are " + zombies.size() + " zombies waiting for them.");
//            System.out.println("It seems " + (survivors.size() - survivorIndex) + " have made it to safety.");
//        } else {
//            System.out.println("We have " + survivors.size() + " survivors trying to make it to safety.");
//            System.out.println("But there are " + zombies.size() + " zombies waiting for them.");
//            System.out.println("It seems the zombies have defeated all the survivors.");
//        }
        if (survivorIndex < survivors.size()) {
            System.out.println((survivors.size() - survivorIndex) + " survivors made it to safety.");
        } else {
            System.out.println("None of the survivors made it.");
        }
    }
}
