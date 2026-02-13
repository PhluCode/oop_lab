package com.rpg.lab01;

public class Character {
    private String name;
    private int level;
    private int healthPoints;
    private int healthPointsMax;
    private Weapon weapon;
    private String characterClass;

    public Character(String name, int level, int healthPointsMax, Weapon weapon, String characterClass){
        this.name = name;
        this.level = level;
        this.healthPoints = healthPointsMax;
        this.healthPointsMax = healthPointsMax;
        this.weapon = weapon;
        this.characterClass = characterClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPointsMax() {
        return healthPointsMax;
    }

    public void setHealthPointsMax(int healthPointsMax) {
        this.healthPointsMax = healthPointsMax;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void displayCharacterDetails(){
        System.out.println("\n --- " + name + " ---");
        System.out.println(" Class: " + characterClass);
        System.out.println(" Level: " + level);
        System.out.println(" Health Points: " + healthPoints + "/" + healthPointsMax);
        System.out.println(" Damage: ");
        System.out.println(" Weapon: " + weapon);
    }

    public int attack() {
        int damage = weapon.getBaseDamage() + (level * 2);
        System.out.println(name + " (" + characterClass + ") attacks with " + weapon.getName() + "!");
        System.out.println(" Attack Damage: " + damage + " (Weapon Base: " + weapon.getBaseDamage() + " +" + " Level Bonus: " + (level*2) + ")");
        return damage;
    }

    public void takeDamage(int damage) {
        healthPoints = healthPoints - damage;
        System.out.println(name + " takes " + damage + " damage!" + "Current HP: " + healthPoints + "/" + healthPointsMax);
    }

    public void levelUp() {
        level++;
        int healthIncrease = 10;
        healthPointsMax = healthPointsMax + healthIncrease;
        healthPoints = healthPointsMax;
        System.out.println("Leveled up to level " + level + "!");
        System.out.println("Max Health increase to " + healthPointsMax + " (full heal applied)");
    }
}
