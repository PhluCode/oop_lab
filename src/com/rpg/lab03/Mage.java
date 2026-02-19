package com.rpg.lab03;

public class Mage extends Character{

    private int mana;
    private int fullMana;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Mage(String characterName, int level, int healthPointsMax, double damage, int defense, int fullMana, Weapon weapon){
        super(characterName, level, healthPointsMax, damage, defense, weapon, "mage");
        this.fullMana = fullMana;
        this.mana = fullMana;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Mana: " + mana + "/" + fullMana);
    }

    @Override
    public void attack(Character enemy) {
        if (this.mana >= 30) {
            setMana(this.mana - 30);
            super.attack(enemy);
            System.out.println(" Mana: " + mana + "/" + fullMana);
        } else {
            System.out.println("Not enough mana!");
        }
    }
}
