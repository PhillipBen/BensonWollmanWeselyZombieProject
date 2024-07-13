/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonassignment1git;
import java.io.Serializable; 
import java.io.*;

/**
 *
 * @author Phillip
 */
public class Pet implements Serializable{
    String name;
    int age;
    
    public Pet(String name, int age) {
        SetName(name);
        SetAge(age);
    }
    
    public void SetName(String name) {
        this.name = name;
    }
    
    public String GetName() {
        return name;
    }
    
    public void SetAge(int age) {
        try {  
            if (age >= 1 && age <= 20) {
                this.age = age;
            }else {
                throw new Exception("Invalid age. Age must be between 1 and 20."); 
            }
        }catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public int GetAge() {
        return age;
    }
}