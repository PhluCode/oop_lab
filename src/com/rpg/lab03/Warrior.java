package com.rpg.lab03;

public class Warrior extends Character {

    private int armorValue;

    public int getArmorValue() {
        return armorValue;
    }

    public void setArmorValue(int armorValue) {
        this.armorValue = armorValue;
    }

    public Warrior(String characterName, int level, int healthPointsMax, double damage, int defense, int armorValue, Weapon weapon) {
        super(characterName, level, healthPointsMax, damage, defense, weapon, "warrior");
        this.armorValue = armorValue;

    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Armor Value: " + armorValue);
    }

    @Override
    public void attack(Character enemy) {

        double boostedDamage = this.getSumDamage() * 1.5;

        System.out.println(" " + this.getName() + "(" + this.getCharacterClass() + ") attacks " + enemy.getName() + " with " + this.getWeapon());
        System.out.println(" Raw Attack Damage (1.5x Bonus): " + boostedDamage);
        System.out.println(" " + enemy.getName() + "'s Defense: " + enemy.getDefense() + " (reduces damage by " + enemy.getDefense() + ")");

        double actualDamage = enemy.receiveDamage(boostedDamage);

        System.out.println(" Actual Damage Taken: " + actualDamage);
        System.out.println(" " + enemy.getName() + "'s HP: " + enemy.getHealthPoints() + "/" + enemy.getHealthPointsMax());

        if (enemy.getHealthPoints() <= 0) {
            System.out.println(" " + enemy.getName() + " has been defeated!");
        }
    }

    @Override
    public double receiveDamage(double rawDamage) {

        double damageAfterArmor = rawDamage - this.armorValue;

        return super.receiveDamage(damageAfterArmor);
    }
}
