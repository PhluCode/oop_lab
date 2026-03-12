package com.rpg.lab06;

public class Character implements Destructible {
    private String name;
    private String status;
    private int level;
    private int healthPoints;
    private int healthPointsMax;
    private double damage;
    private int defense;
    private Weapon weapon;
    private String characterClass;
    protected Attack attackBehavior;

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
        this.attackBehavior = new BaseAttack();
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

    public Attack getAttack() {
        return attackBehavior;
    }

    public void setAttack(Attack attack) {
        this.attackBehavior = attack;
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

    public void attack(Destructible enemy) {
        if (this.isAlive()) {

            this.attackBehavior.attack(this, enemy);

            if (enemy.isDestroyed()) {
                System.out.println(" " + enemy.getName() + " has been defeated/shattered!");
            }
        } else {
            System.out.println(this.name + " is too exhausted to attack!");
        }
    }

    public void levelUp() {
        level++;
        int healthIncrease = 10;
        healthPointsMax = healthPointsMax + healthIncrease;
        healthPoints = healthPointsMax;
        System.out.println("Leveled up to level " + level + "!");
        System.out.println("Max Health increase to " + healthPointsMax + " (full heal applied)");
    }

    @Override
    public double takeDamage(double amount) {
        double actualDamageTaken = Math.max(0.0, amount - this.defense);
        this.setHealthPoints((int) (this.healthPoints - actualDamageTaken));
        return actualDamageTaken;
    }

    @Override
    public boolean isDestroyed() {
        return this.healthPoints <= 0;
    }

}
