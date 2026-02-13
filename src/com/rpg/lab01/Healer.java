package com.rpg.lab01;

public class Healer extends Character{
    private int healpoints;
    private int healAmount;
    private int healBonus;

    public Healer(String name, int level, int healthPointsMax, Weapon weapon, int healpoints){
        super(name, level, healthPointsMax, weapon, "healer");
        this.healpoints = healpoints;
        healBonus = (getLevel() * 3);
        healAmount = healpoints + healBonus;
    }

    public void heal(){

        setHealthPoints(getHealthPoints() + healAmount);

        if (getHealthPoints() > getHealthPointsMax()){
            setHealthPoints(getHealthPointsMax());
        }

        System.out.println(getName() + " (Healer) casts a healing spell!");
        System.out.println("Healing Amount: " + healAmount + " (Base: " + healpoints + " + " + "Level Bonus: " +  healBonus + ")");
        System.out.println("Restored " + healAmount + " HP! " + "Current HP: " + getHealthPoints() + "/" + getHealthPointsMax());
    }

    public void healAlly(Character character) {

        character.setHealthPoints(character.getHealthPoints() + healAmount);

        if (character.getHealthPoints() > character.getHealthPointsMax()) {
            character.setHealthPoints(character.getHealthPointsMax());
        }

        System.out.println(getName() + " (Healer) casts a healing spell on " + character.getName() + "!");
        System.out.println("Heal Amount: " + healAmount);
        System.out.println("Restored: " + healAmount + " HP to " + character.getName() + "! Their HP: " + character.getHealthPoints() + "/" + character.getHealthPointsMax());
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Healing Power: " + healAmount);
    }
}
