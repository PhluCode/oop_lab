package com.rpg.lab06;

public class Archer extends Character {

    private int accuracy;

    public Archer(String characterName, int level, int healthPointsMax, double damage, int defense, int accuracy, Weapon weapon) {
        super(characterName, level, healthPointsMax, damage, defense, weapon, "archer");
        this.accuracy = accuracy;

        this.setAttack(new ArcherStyleDecorator(this.getAttack()));
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Accuracy: " + accuracy + "%");
        System.out.println(" Range Advantage: " + (hasRangeAdvantage() ? "Yes (30% Bonus)" : "No"));
    }

    public boolean hasRangeAdvantage() {
        return Math.random() < 0.5;
    }
}
