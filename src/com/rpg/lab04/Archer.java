package com.rpg.lab04;

public class Archer extends Character {

    private int accuracy;

    public Archer(String characterName, int level, int healthPointsMax, double damage, int defense, int accuracy, Weapon weapon) {
        super(characterName, level, healthPointsMax, damage , defense, weapon, "archer");
        this.accuracy = accuracy;
    }

    @Override
    public void displayCharacterDetails() {
        super.displayCharacterDetails();
        System.out.println(" Accuracy: " + accuracy + "%");
        System.out.println(" Range Advantage: Yes (30% Bonus)" );
    }

    @Override
    public void attack(Destructible target) {
        double roll = Math.random();
        double hitThreshold = this.accuracy / 100.0;
        double finalDamage = 0;
        boolean isHit = roll <= hitThreshold;

        System.out.println("\n " + this.getName() + " (Archer) fires an arrow at " + target.getName() + "!");

        if (!isHit) {

            System.out.println(" [MISS] The arrow flew past the target! (Accuracy: " + this.accuracy + "%)");
            System.out.println(" Actual Damage Taken: 0.0");
        } else {

            finalDamage = this.getSumDamage() * 1.3;
            System.out.println(" [HIT] Direct strike! (Accuracy: " + this.accuracy + "%)");
            System.out.println(" Raw Damage: " + (int)this.getSumDamage() + " → Enhanced: " + (int)finalDamage + " (1.3x Range Advantage)");

            if (target instanceof Character) {

                Character enemy = (Character) target;
                int defense = (int) enemy.getDefense();
                int damageAfterDefense = (int)finalDamage - defense;

                System.out.println(" " + enemy.getName() + "'s Defense: " + defense + " (reduces damage from " + (int)finalDamage + " to " + damageAfterDefense + ")");
                double actual = enemy.takeDamage(finalDamage);
                System.out.println(" Actual Damage Taken: " + actual);
                System.out.println(" " + target.getName() + "'s HP: " + target.getHealthPoints() + "/" + target.getHealthPointsMax());
            } else {

                target.takeDamage(finalDamage);
            }
        }
    }
}
