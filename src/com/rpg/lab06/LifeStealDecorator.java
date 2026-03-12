package com.rpg.lab06;

public class LifeStealDecorator extends AttackDecorator{
    private final double ratio;
    public LifeStealDecorator(Attack wrappedAttack, double ratio) {
        super(wrappedAttack);
        if (ratio < 0 || ratio > 1) {
            throw new IllegalArgumentException("Life steal ratio must be between 0 and 1.");
        }
        this.ratio = ratio;
    }
    @Override
    public void attack(Character attacker, Destructible target) {
        wrappedAttack.attack(attacker, target);

        if (!attacker.isAlive()) return;

        int hpAfterAttack = attacker.getHealthPoints();
        double effectiveDamage = attacker.getDamage();
        int healAmount = (int) Math.round(effectiveDamage * ratio);

        int missing = attacker.getHealthPointsMax() - hpAfterAttack;
        if (missing <= 0 || healAmount <= 0) return;

        int restored = Math.min(healAmount, missing);
        attacker.setHealthPoints(hpAfterAttack + restored);

        System.out.println(" [Decorator] Life Steal restored " + restored + " HP to " +
                attacker.getName() + " (" + hpAfterAttack + " -> " + attacker.getHealthPoints() + ")");
    }
}
