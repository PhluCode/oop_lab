package com.rpg.lab03;

public class Character {
    private String name;
    private String status;
    private int level;
    private int healthPoints;
    private int healthPointsMax;
    private double damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;
    private double sumDamage;

    public Character(String name, int level, int healthPointsMax, double damage, int defense, Weapon weapon, String characterClass){
        this.name = name;
        this.status = "Active";
        this.level = level;
        this.healthPoints = healthPointsMax;
        this.healthPointsMax = healthPointsMax;
        this.damage = damage;
        this.defense = defense;
        this.weapon = weapon;
        this.characterClass = characterClass;
        this.sumDamage = this.damage + weapon.getBaseDamage();
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
        if (healthPoints < 0) {
            this.healthPoints = 0;
        }

        else if (healthPoints > this.healthPointsMax) {
            this.healthPoints = this.healthPointsMax;
        }
        else {
            this.healthPoints = healthPoints;
        }
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {}

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public double getSumDamage() {
        return sumDamage;
    }

    public void setSumDamage(double sumDamage) {
        this.sumDamage = sumDamage;
    }

    public void displayCharacterDetails(){
        System.out.println("\n --- " + name + " ---");
        System.out.println(" Class: " + characterClass);
        System.out.println(" Status: " + status);
        System.out.println(" Level: " + level);
        System.out.println(" Health Points: " + healthPoints + "/" + healthPointsMax);
        System.out.println(" Damage: " + damage);
        System.out.println(" Defense: " + defense);
        System.out.println(" Weapon: " + weapon);
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void attack(Character enemy) {

        System.out.println(" " + this.name + "(" + this.characterClass + ") attacks " + enemy.getName() + " with " + this.weapon);
        System.out.println(" Raw Attack Damage: " + this.sumDamage);
        System.out.println(" " + enemy.getName() + "'s Defense: " + enemy.getDefense() + " (reduces damage by " + enemy.getDefense() + ")");
        System.out.println(" Actual Damage Taken: " + enemy.receiveDamage(this.sumDamage));
        System.out.println(" " + enemy.getName() + "'s HP: " + enemy.getHealthPoints() + "/" + enemy.getHealthPointsMax() );

        if (enemy.getHealthPoints() <= 0) {
            System.out.println(" " + enemy.getName() + " has been defeated!");
        }
    }

    public double receiveDamage(double rawDamage) {

        double actualDamageTaken = Math.max(0.0, rawDamage - this.defense);

        this.setHealthPoints((int) (this.healthPoints - actualDamageTaken));

        return actualDamageTaken;
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
