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
    
    public void PrintDatabase() {
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
}
