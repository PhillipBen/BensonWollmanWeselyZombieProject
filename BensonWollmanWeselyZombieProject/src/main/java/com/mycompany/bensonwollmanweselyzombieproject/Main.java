/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Phillip
 * 
 * Netbeans: View Function tooltips with Control + Shift + Space.
 */
public class Main {
    
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of zombies: ");
        int numberOfZombies = scanner.nextInt();
        System.out.print("Enter the number of survivors: ");
        int numberOfSurvivors = scanner.nextInt();

        Zombie[] zombies = new Zombie[numberOfZombies];
        Survivor[] survivors = new Survivor[numberOfSurvivors];

        for (int i = 0; i < numberOfZombies; i++) {
            zombies[i] = new Zombie();
        }
        for (int i = 0; i < numberOfSurvivors; i++) {
            survivors[i] = new Survivor();
        }

        int zombieIndex = 0;
        int survivorIndex = 0;

        while (zombieIndex < numberOfZombies && survivorIndex < numberOfSurvivors) {
            Survivor survivor = survivors[survivorIndex];
            Zombie zombie = zombies[zombieIndex];

            while (zombie.is_alive() && survivor.is_alive()) {
                survivor.attack_enemy(zombie);
                System.out.println("Zombie health after attack: " + zombie.getHealth());
                if (!zombie.is_alive()) {
                    System.out.println("Hoorah! Zombie has died!");
                    break;
                }

                zombie.attack_enemy(survivor);
                System.out.println("Survivor health after attack: " + survivor.getHealth());
                if (!survivor.is_alive()) {
                    System.out.println("Sad day, rest in peace soldier.");
                    break;
                }
            }

            if (!zombie.is_alive()) {
                zombieIndex++;
            } else if (!survivor.is_alive()) {
                survivorIndex++;
            }
        }
        if (survivorIndex < numberOfSurvivors) {
            System.out.println("We have " + numberOfSurvivors + " survivors trying to make it to safety.");
            System.out.println("But there are " + numberOfZombies + " zombies waiting for them.");
            System.out.println("It seems " + (numberOfSurvivors - survivorIndex) + " have made it to safety.");
        } else {
            System.out.println("We have " + numberOfSurvivors + " survivors trying to make it to safety.");
            System.out.println("But there are " + numberOfZombies + " zombies waiting for them.");
            System.out.println("It seems the zombies have defeated all the survivors.");
        }
    }
}
