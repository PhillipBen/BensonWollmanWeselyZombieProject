/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bensonassignment1git;

import java.util.Scanner;

/**
 *
 * @author Phillip
 */

public class BensonAssignment1Git {

    public static void main(String[] args) {
        System.out.println("Pet Database Program.");
        
        Scanner choiseScnr = new Scanner(System.in);
        Scanner scnr = new Scanner(System.in);
        PetDatabase PD = new PetDatabase();
        int userInput = -1;
        
        while(userInput != 7) {
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) Remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            System.out.println("Your choice:");
            
            userInput = choiseScnr.nextInt();
            
            switch (userInput) {
                case 1 -> {
                    PD.PrintDatabase();
                }
                case 2 -> {
                    System.out.println("add pet (name, age):");
                    String userStrInput = scnr.nextLine();
                    Pet tempPet = new Pet(userStrInput.split(" ")[0], Integer.parseInt(userStrInput.split(" ")[1]));
                    PD.Add(tempPet);
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                    System.out.println("Enter a name to search:");
                    PD.SearchDatabase(0, scnr.nextLine());
                }
                case 6 -> {
                    System.out.println("Enter a age to search:");
                    PD.SearchDatabase(1, scnr.nextLine());
                }
                default -> {
                }
            }
        }
        
        
        
    }
    
    
}
