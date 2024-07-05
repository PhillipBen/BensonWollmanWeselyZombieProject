/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bensonassignment1git;

/**
 *
 * @author Phillip
 */
public class Pet {
    String name;
    int age;
    
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void SetName(String name) {
        this.name = name;
    }
    
    public String GetName() {
        return name;
    }
    
    public void SetAge(int age) {
        this.age = age;
    }
    
    public int GetAge() {
        return age;
    }
}
