package com.rpg.lab04;

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
    public void attack(Destructible target) {
        int baseDamage = (int) this.getSumDamage();
        int enhancedDamage = (int) (baseDamage * 1.5);

        System.out.println("\n " + this.getName() + " (Warrior) performs a POWERFUL STRIKE on " + target.getName() + "!");
        System.out.println(" Base Damage: " + baseDamage + " → Enhanced: " + enhancedDamage + " (1.5x multiplier)");

        if (target instanceof Warrior) {

            Warrior enemy = (Warrior) target;
            int armor = (int) enemy.getArmorValue();
            int defense = (int) enemy.getDefense();
            int damageAfterArmor = enhancedDamage - armor;
            int damageAfterDefense = damageAfterArmor - defense;

            System.out.println(" " + enemy.getName() + "'s Armor: " + armor + " (reduces damage from " + enhancedDamage + " to " + damageAfterArmor + ")");
            System.out.println(" " + enemy.getName() + "'s Defense: " + defense + " (reduces damage from " + damageAfterArmor + " to " + damageAfterDefense + ")");

            double actual = enemy.takeDamage(enhancedDamage);
            System.out.println(" Actual Damage Taken: " + actual);
            System.out.println(" " + target.getName() + "'s HP: " + target.getHealthPoints() + "/" + target.getHealthPointsMax());

        } else if (target instanceof Character) {

            Character enemy = (Character) target;
            int defense = (int) enemy.getDefense();
            int damageAfterDefense = enhancedDamage - defense;

            System.out.println(" " + enemy.getName() + "'s Defense: " + defense + " (reduces damage from " + enhancedDamage + " to " + damageAfterDefense + ")");
            double actual = enemy.takeDamage(enhancedDamage);
            System.out.println(" Actual Damage Taken: " + actual);
            System.out.println(" " + target.getName() + "'s HP: " + target.getHealthPoints() + "/" + target.getHealthPointsMax());
        } else {

            target.takeDamage(enhancedDamage);
        }
    }

    @Override
    public double takeDamage(double rawDamage) {

        double damageAfterArmor = rawDamage - this.armorValue;

        return super.takeDamage(damageAfterArmor);
    }
}
