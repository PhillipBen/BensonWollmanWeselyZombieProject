/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bensonassignment1git;

import java.util.Scanner;
import java.io.*;

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
        while(userInput != 9) {
            //User input info
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) Remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Save current PetDatabase");
            System.out.println("8) Load a PetDatabase");
            System.out.println("9) Exit program");
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
                    String[] userStrInputList = userStrInput.split(" ");
                    if (userStrInputList.length == 2) {
                        //Input validation to make sure only two items were entered
                        String tempPetName = userStrInputList[0];
                        int tempPetAge = Integer.parseInt(userStrInputList[1]);
                        Pet tempPet = new Pet(tempPetName, tempPetAge);
                        if(tempPet.GetAge() != 0) {
                            //Age validation to make sure the correct age was entered
                            PD.Add(tempPet);
                        }
                    }else {
                        System.out.println("ERROR: Invalid Input length.");
                    }
                    
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
                case 7 -> {
                    //Save the PetDatabase to a file
                    System.out.println("Enter a file name to save this database as:");
                    String userStrInput = scnr.nextLine();
                    PD.save(PD, userStrInput);
                }
                case 8 -> {
                    //Load the PetDatabase from a file
                    try {  
                        System.out.println("Enter a file name to load the database from:");
                        String userStrInput = scnr.nextLine();
                        PD = PD.load(userStrInput);
                    }catch(IOException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
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
