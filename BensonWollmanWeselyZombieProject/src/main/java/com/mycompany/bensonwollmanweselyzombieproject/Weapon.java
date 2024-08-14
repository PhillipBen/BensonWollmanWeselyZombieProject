package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.Random;

public class Weapon {
    protected double attack;
    protected int accuracy;
    protected String name;

    public Weapon() {
        weapon_select();
    }
    public void weapon_select() {
        Random randGen = new Random();
        int weapon = randGen.nextInt(0,6);
        switch (weapon) {
            case 0:
                this.name = "shotgun";
                this.attack = 70;
                this.accuracy = 90;
                break;
            case 1:
                this.name = "submachine gun";
                this.attack = 20;
                this.accuracy = 70;
                break;
            case 2:
                this.name = "assault rifle";
                this.attack = 40;
                this.accuracy = 80;
                break;
            case 3:
                this.name = "pistol";
                this.attack = 20;
                this.accuracy = 80;
                break;
            case 4:
                this.name = "RPG";
                this.attack = 300;
                this.accuracy = 50;
                break;
            case 5:
                this.name = "crowbar";
                this.attack = 15;
                this.accuracy = 95;
                break;
            case 6:
                this.name = "frying pan";
                this.attack = 10;
                this.accuracy = 95;
                break;
        }
    }
    public String getWeaponName() {
        return this.name;
    }
}