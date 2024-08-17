package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.Random;
public class WeaponCache {
    /*
     * Creating an array of Weapon objects that CANNOT be modified, and is shared amongst
     * all instances of WeaponCache.
     */
    private static final Weapon[] WEAPONS = {
            new Weapon("Shotgun", 70, 0.9),
            new Weapon("Submachine Gun", 20, 0.7),
            new Weapon("Assault Rifle", 40, 0.8),
            new Weapon("Pistol", 20, 0.8),
            new Weapon("RPG", 300, 0.5),
            new Weapon("Crowbar", 15, 0.95),
            new Weapon("Frying Pan", 10, 0.95)
    };
    /*
     * this method was created as a way to randomly fill the array, our implementation of
     * weapon class, with random weapons. The array size is based off of total number of
     * survivors.
     */
    public static Weapon getRandWeapon() {
        Random rand = new Random();
        return WEAPONS[rand.nextInt(WEAPONS.length)];
    }
    /*
     * Method that randomly generates weapons into an array and returns an array
     * of weapon objects.
     */
    public static Weapon[] generateWeapons(int totalSurvivors) {
        Weapon[] weapons = new Weapon[totalSurvivors];
        for (int i = 0; i < totalSurvivors; i++) {
            weapons[i] = WeaponCache.getRandWeapon();
        }
        return weapons;
    }
}
