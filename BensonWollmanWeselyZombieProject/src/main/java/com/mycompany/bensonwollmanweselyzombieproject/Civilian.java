package com.mycompany.bensonwollmanweselyzombieproject;

public class Civilian extends Survivor {
    public Civilian(int id, Weapon weapon) {
        super(50, 5, "Civilian", id, weapon);
    }
    /*
     * This was originally used for testing battle logic with output, but that has
     * been taken out for a more polished v3 release.
     */
    @Override
    public String toString() {
        return String.format("Civilian{id=%d, weapon=%s}", getId(), getWeapon());
    }
}