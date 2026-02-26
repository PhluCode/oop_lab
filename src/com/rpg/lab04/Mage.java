package com.rpg.lab04;

public class Mage extends Character {

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
    public void attack(Destructible target) {
        int spellBase = 40;
        int spellBonus = 10;
        int totalSpellDamage = spellBase + spellBonus;
        int manaCost = 30;

        if (this.mana < manaCost) {
            // กรณีมานาไม่พอ
            System.out.println(this.getName() + " attempts to cast Magic Missile, but has insufficient mana!");
            System.out.println("Current Mana: " + this.mana + "/" + this.fullMana + " (Need: " + manaCost + ")");
            return; // ออกจากเมธอดทันที ไม่เกิดการโจมตี
        }

        this.mana -= manaCost;

        System.out.println("\n " + this.getName() + " (Mage) casts MAGIC MISSILE at " + target.getName() + "!");
        System.out.println(" Spell Damage: " + totalSpellDamage + " (Base: " + spellBase + " + Spell Bonus: " + spellBonus + ")");
        System.out.println(" Mana Used: " + manaCost + " | Remaining: " + this.mana + "/" + fullMana);

        if (target instanceof Character) {
            Character enemy = (Character) target;
            int defense = (int) enemy.getDefense();
            int damageAfterDefense = totalSpellDamage - defense;

            System.out.println(" " + enemy.getName() + "'s Defense: " + defense + " (reduces damage from " + totalSpellDamage + " to " + damageAfterDefense + ")");
            double actual = enemy.takeDamage(totalSpellDamage);
            System.out.println(" Actual Damage Taken: " + actual);
            System.out.println(" " + target.getName() + "'s HP: " + target.getHealthPoints() + "/" + target.getHealthPointsMax());
        } else {
            target.takeDamage(totalSpellDamage);
        }
    }
}
