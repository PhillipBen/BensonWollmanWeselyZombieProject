package com.mycompany.bensonwollmanweselyzombieproject;

public class Scientist extends Survivor{
    public Scientist(int id, Weapon weapon) {
        super(20, 2, "Scientist", id, weapon);
    }
    /*
     * This was originally used for testing battle logic with output, but that has
     * been taken out for a more polished v3 release.
     */
    @Override
    public String toString() {
        return String.format("Scientist{id=%d, weapon=%s}", getId(), getWeapon());
    }
}
