package com.rpg.lab06;

public class StoneWall implements Destructible {
    private String name;
    private int hp;
    private int maxHp;
    private String wallType;

    public StoneWall(String name, int hp, String wallType) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.wallType = wallType;
    }

    public void displayWallDetails() {
        System.out.println("\n--- " + name.toUpperCase() + " ---");
        System.out.println("Type: " + wallType);
        System.out.println("Status: " + (isDestroyed() ? "COLLAPSED" : "STANDING"));
        System.out.println("Durability: " + hp + "/" + maxHp);
    }

    @Override
    public double takeDamage(double amount) {
        if (hp > 0) {
            hp -= amount;
            if (hp <= 0) {
                hp = 0;
            }
            System.out.println(name + " [" + wallType + "] is hit! Current HP: " + Math.max(0, hp) + "/" + maxHp);
            if (isDestroyed()) {
                System.out.println(name + " has crumbled into dust!");
            }
        }
        return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return hp;
    }

    @Override
    public int getDefense() {
        return 0;
    }

    @Override
    public int getHealthPointsMax() {
        return maxHp;
    }

    @Override
    public boolean isDestroyed() {
        return hp <= 0;
    }
}
