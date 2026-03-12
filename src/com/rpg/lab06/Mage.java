package com.rpg.lab06;

public class Mage extends Character {

    private int mana;
    private int fullMana;

    // Getter/Setter เหมือนเดิม
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getFullMana() { return fullMana; }

    public Mage(String characterName, int level, int healthPointsMax, double damage, int defense, int fullMana, Weapon weapon){
        super(characterName, level, healthPointsMax, damage, defense, weapon, "mage");
        this.fullMana = fullMana;
        this.mana = fullMana;

        this.setAttack(new MageStyleDecorator(this.getAttack()));
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Mana: " + mana + "/" + fullMana);
    }

}