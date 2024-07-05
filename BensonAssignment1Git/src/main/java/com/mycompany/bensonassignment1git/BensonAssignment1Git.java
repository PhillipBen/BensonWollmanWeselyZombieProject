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
        
        //Initialization
        Scanner choiseScnr = new Scanner(System.in);
        Scanner scnr = new Scanner(System.in);
        PetDatabase PD = new PetDatabase();
        int userInput = -1;
        
        //Main user input method
        while(userInput != 7) {
            //User input info
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
                    //print Pet List
                    PD.PrintDatabase();
                }
                case 2 -> {
                    //Add Pet
                    System.out.println("add pet (name, age):");
                    String userStrInput = scnr.nextLine();
                    Pet tempPet = new Pet(userStrInput.split(" ")[0], Integer.parseInt(userStrInput.split(" ")[1]));
                    PD.Add(tempPet);
                }
                case 3 -> {
                    //Update a pet
                    PD.PrintDatabase();
                    System.out.println("Enter the index of the pet you would like to update:");
                    int petIndex = Integer.parseInt(scnr.nextLine());
                    System.out.println("add your new pet (name, age):");
                    String userStrInput = scnr.nextLine();
                    Pet newPet = new Pet(userStrInput.split(" ")[0], Integer.parseInt(userStrInput.split(" ")[1]));
                    PD.Update(petIndex, newPet);
                }
                case 4 -> {
                    //Remove a pet
                    PD.PrintDatabase();
                    System.out.println("Enter the index of the pet you would like to remove:");
                    PD.Remove(Integer.parseInt(scnr.nextLine()));
                }
                case 5 -> {
                    //Search for pet(s) with a specific name
                    System.out.println("Enter a name to search:");
                    PD.SearchDatabase(0, scnr.nextLine());
                }
                case 6 -> {
                    //Search for pet(s) with a specific age
                    System.out.println("Enter a age to search:");
                    PD.SearchDatabase(1, scnr.nextLine());
                }
                default -> {
                    //All other inputs
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
