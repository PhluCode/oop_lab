package com.rpg.lab03;

public class Archer extends Character{

    private int accuracy;

    public Archer(String characterName, int level, int healthPointsMax,  double damage, int defense, int accuracy, Weapon weapon) {
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
    public void attack(Character enemy) {
        double roll = Math.random();
        double finalDamage = 0;
        String combatDisplay = "";

        double hitThreshold = this.accuracy / 100.0;

        if (roll > hitThreshold) {
            // กรณีที่ 1: ยิงพลาด (15% ของโอกาสทั้งหมด)
            combatDisplay = " [MISS] The arrow missed the target!";
            finalDamage = 0;
        } else {
            finalDamage = this.getSumDamage() * 1.3;
            combatDisplay = " [HIT] Direct arrow strike! (30% Range Bonus)";
        }

        System.out.println(combatDisplay);

        // ส่งความเสียหายไปยังศัตรู
        double actualTaken = enemy.receiveDamage(finalDamage);

        System.out.println(" Raw Attack Damage: " + finalDamage);
        System.out.println(" " + enemy.getName() + "'s Defense: " + enemy.getDefense() + " (reduces damage by " + enemy.getDefense() + ")");
        System.out.println(" Actual Damage Taken: " + actualTaken);
        System.out.println(" " + enemy.getName() + " HP: " + enemy.getHealthPoints() + "/" + enemy.getHealthPointsMax());
    }
}
