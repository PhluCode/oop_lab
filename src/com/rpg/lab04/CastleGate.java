package com.rpg.lab04;

public class CastleGate implements Destructible{
    private String name;
    private int hp;
    private int maxHp;
    private boolean isReinforced;
    private boolean hasDrawbridge;

    public CastleGate(String name, int hp, boolean isReinforced, boolean hasDrawbridge) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.isReinforced = isReinforced;
        this.hasDrawbridge = hasDrawbridge;
    }

    public void displayGateDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Status: " + (isDestroyed() ? "BREACHED" : "INTACT"));
        System.out.println("Durability: " + hp + "/" + maxHp);
        System.out.println("Locked: " + (hp > 0 ? "Yes" : "No")); // หรือใช้ตัวแปร isLocked ถ้าคุณมี
        System.out.println("Reinforced: " + (isReinforced ? "Yes" : "No"));
    }

    @Override
    public double takeDamage(double amount) {
        if (hp > 0) {

            int finalDamage = (int) (isReinforced ? amount / 2 : amount);
            hp -= finalDamage;

            if (hp <= 0) {
                hp = 0;
            }

            System.out.println(name + (isReinforced ? " (Reinforced)" : "") + " shudders! Takes " + finalDamage + " damage.");
            System.out.println(name + " HP: " + Math.max(0, hp) + "/" + maxHp);

            if (isDestroyed()) {
                System.out.println("THE " + name.toUpperCase() + " HAS BEEN BREACHED!");
            }
        }
        return amount;
    }

    @Override public String getName() { return name; }
    @Override public int getHealthPoints() { return hp; }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override public int getHealthPointsMax() { return maxHp; }
    @Override public boolean isDestroyed() { return hp <= 0; }
}
