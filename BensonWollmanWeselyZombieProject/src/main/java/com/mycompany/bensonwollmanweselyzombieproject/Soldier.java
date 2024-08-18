package com.mycompany.bensonwollmanweselyzombieproject;

public class Soldier extends Survivor{
    public Soldier(int id, Weapon weapon) {
        super(100, 10, "Soldier", id, weapon);
    }
    /*
     * This was originally used for testing battle logic with output, but that has
     * been taken out for a more polished v3 release.
     */
    @Override
    public String toString() {
        return String.format("Soldier{id=%d, weapon=%s}", getId(), getWeapon());
    }
}
