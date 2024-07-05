/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonassignment1git;

import java.util.ArrayList;

/**
 *
 * @author Phillip
 */
public class PetDatabase {
    ArrayList<Pet> petList = new ArrayList<>();
    
    public void Add(Pet pet) {
        petList.add(pet);
    }
    
    public void Update(int index, Pet newPet) {
        petList.remove(index);
        petList.add(index, newPet);
    }
    
    public void Remove(int index) {
        petList.remove(index);
    }
    
    public void PrintDatabase() {
        //Print the petList from this class
        System.out.println("");
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME      | AGE |");
        System.out.println("+----------------------+");
        for (int i = 0; i < petList.size(); i++) {
            System.out.printf("%-5s%-12s%-6s%-1s%n", "| " + i, "| " + petList.get(i).GetName(), "| " + petList.get(i).GetAge(), "|"); 
        }
        System.out.println("+----------------------+");
        System.out.println("" + petList.size() + " rows in set.");
        System.out.println("");
    }
    
    public void PrintDatabase(ArrayList<Pet> arrayList) {
        //Print an input arrayList, given it is an ArrayList that contains Pet(s).
        System.out.println("");
        System.out.println("+----------------------+");
        System.out.println("| ID | NAME      | AGE |");
        System.out.println("+----------------------+");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%-5s%-12s%-6s%-1s%n", "| " + i, "| " + arrayList.get(i).GetName(), "| " + arrayList.get(i).GetAge(), "|"); 
        }
        System.out.println("+----------------------+");
        System.out.println("" + arrayList.size() + " rows in set.");
        System.out.println("");
    }
    
    public void SearchDatabase(int searchCase, String searchString) {
        //Searches the petList for a specific name or age and prints all found results.
        //searchCase: 0 = name, 1 = age
        ArrayList<Pet> tempPetList = new ArrayList<>();
        if(searchCase == 0) {
            //name
            for (int i = 0; i < petList.size(); i++) 
                if (petList.get(i).GetName().toLowerCase().equals(searchString.toLowerCase()))
                    tempPetList.add(petList.get(i));
        }else {
            //age
            for (int i = 0; i < petList.size(); i++) 
                if (petList.get(i).GetAge() == Integer.parseInt(searchString))
                    tempPetList.add(petList.get(i));
        }
        PrintDatabase(tempPetList);
    }
}