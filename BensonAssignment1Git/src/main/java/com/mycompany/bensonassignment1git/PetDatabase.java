/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonassignment1git;

import java.util.ArrayList;
import java.io.Serializable; 
import java.io.*;

/**
 *
 * @author Phillip
 */
public class PetDatabase implements Serializable{
    ArrayList<Pet> petList = new ArrayList<>();
    
    public void Add(Pet pet) {
        try {  
            if (petList.size() < 5) {
                petList.add(pet);
            }else {
                throw new Exception("Invalid add. Pet List size greater than or equal to five."); 
            }
        }catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public void Update(int index, Pet newPet) {
        petList.remove(index);
        petList.add(index, newPet);
    }
    
    public void Remove(int index) {
        if(index >= 0 && index < petList.size()) {
            petList.remove(index);
        }else {
            System.out.println("That index does not exist!");
        }
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
    
    public boolean save(PetDatabase testSet, String filename) {
        //Source: https://www.geeksforgeeks.org/serializable-interface-in-java/
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos); 
            oos.writeObject(testSet); 
            oos.close();
            fos.close();
            return true;
        }catch(IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    public PetDatabase load(String filename) throws IOException {
        //Source: https://www.geeksforgeeks.org/serializable-interface-in-java/
        try {
            FileInputStream fis = new FileInputStream(filename); 
            ObjectInputStream ois = new ObjectInputStream(fis);
            PetDatabase PD = (PetDatabase)ois.readObject();
            fis.close();
            ois.close();
            System.out.println("Test loaded successfully!");
            return PD;
        }catch(IOException | ClassNotFoundException e) {
            System.out.println("Failed to load file");
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }
}