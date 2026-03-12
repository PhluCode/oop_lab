package com.rpg.lab06;

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

        this.setAttack(new WarriorStyleDecorator(this.getAttack()));
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Armor Value: " + armorValue);
    }

    @Override
    public double takeDamage(double rawDamage) {
        double damageAfterArmor = rawDamage - this.armorValue;
        if (damageAfterArmor < 0) damageAfterArmor = 0;

        return super.takeDamage(damageAfterArmor);
    }
}
