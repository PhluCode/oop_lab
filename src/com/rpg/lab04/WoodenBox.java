package com.rpg.lab04;

public class WoodenBox implements Destructible {
    private String name;
    private int hp;
    private int maxHp;
    private boolean isLocked;
    private String loot;

    public WoodenBox(String name, int maxHp, boolean isLocked, String loot) {
        this.name = name;
        this.hp = maxHp;
        this.isLocked = isLocked;
        this.loot = loot;
        this.maxHp = maxHp;
    }

    public void displayBoxDetails() {
        System.out.println("\n--- WOODEN BOX DETAILS ---");
        System.out.println(" - Name: " + name);
        System.out.println(" - HP: " + hp + "/" + maxHp);
        System.out.println(" - Locked: " + (isLocked ? "Yes" : "No"));
        System.out.println(" - Loot Inside: " + loot);
        System.out.println(" - Status: " + (isDestroyed() ? "Shattered" : "Intact"));
    }

    public void breakOpen() {
        if (isDestroyed()) {
            System.out.println("The lock broke! " + this.name + " breaks open!");
            System.out.println("Contents revealed: " + this.loot);
        } else {
            System.out.println("Cannot break open " + this.name + " - it's still intact");
        }
    }

    @Override
    public double takeDamage(double amount) {
        if (hp > 0) {
            hp -= amount;
            if (hp <= 0) {
                hp = 0;
            }
            System.out.println(name + " was hit! Current HP: " + Math.max(0, hp) + "/" + maxHp);
            if (isDestroyed()) {
                System.out.println("The box shattered! You found: " + loot);
            }
        }
        return amount;
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealthPoints() {
        return 0;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getHealthPointsMax() {
        return 0;
    }
}
