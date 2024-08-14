package com.mycompany.bensonwollmanweselyzombieproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeaponCache {
    private static final List<Weapon> weapons = new ArrayList<>();

    static {
        weapons.add(new Weapon("shotgun", 70, 0.9));
        weapons.add(new Weapon("submachine gun", 20, 0.7));
        weapons.add(new Weapon("assault rifle", 40, 0.8));
        weapons.add(new Weapon("pistol", 20, 0.8));
        weapons.add(new Weapon("RPG", 300, 0.5));
        weapons.add(new Weapon("crowbar", 15, 0.95));
        weapons.add(new Weapon("frying pan", 10, 0.95));
    }

    public static Weapon weapon_select() {
        Random rand = new Random();
        return weapons.get(rand.nextInt(weapons.size()));
    }
}
