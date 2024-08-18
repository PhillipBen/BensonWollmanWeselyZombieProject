package com.mycompany.bensonwollmanweselyzombieproject;
public abstract class Character {
    /*
     * ints will work but opted for double if/when future versions of the game have more
     * complex attacking situations where you'll need more granularity into health.
     */
    protected double health;
    protected double attack;
    protected String type;
    protected int id;

    public Character(double health, double attack, String type, int id) {
        this.health = health;
        this.attack = attack;
        this.type = type;
        this.id = id;
    }

    public Character() {
        this.health = 100;
        this.attack = 10;
    }
    
    /**
    * Check answer.
    * @param enemy Character: The enemy that is being attacked.
    */
    public void attack_enemy(Character enemy) {
        enemy.take_damage(attack);
    }
    public String getType() {
        return this.type;
    }
    public int getId() {
        return this.id;
    }
    /*
     * @return True if health is greater than 0.
     */
    public boolean is_alive() {
        return this.health > 0;
    }
    /*
    * @param damage Double: The amount of damage being done.
    */
    public void take_damage(double damage) {
        this.health -= damage;
        // System.out.println(get_entity() + " took " + damage + " damage.");
    }

    /*
    * @return String: Returns the entity type of this instance.
    */
    public String get_entity() {
        if(this instanceof Zombie) {
            return "Zombie";
        }else if(this instanceof Survivor) {
            return "Survivor";
        }else {
            return "NULL";
        }
    }
    /*
     * Implemented logic within the death statement to print a weapon only if
     * the attacker is a survivor.
     */
    public void death_statement(Character attacker) {
        if (attacker instanceof Survivor survivor) {
            System.out.println(survivor.getType() + " " + survivor.getId() + " killed " + this.getType() + " "
                    + this.getId() + " with " + survivor.getWeapon().getName());
        } else if (attacker instanceof Zombie) {
            System.out.println(attacker.getType() + " " + attacker.getId() + " killed " + this.getType() + " "
                    + this.getId());
        }
    }
}
