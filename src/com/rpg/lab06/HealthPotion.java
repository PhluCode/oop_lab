package com.rpg.lab06;

public class HealthPotion implements Consumable {
    private String name;
    private int healAmount;
    private int quantity;

    public HealthPotion(String name, int healAmount, int quantity) {
        this.name = name;
        this.healAmount = healAmount;
        this.quantity = quantity;
    }

    public void displayPotionDetails() {
        System.out.println("\n--- POTION DETAILS ---");
        System.out.println(" - Name: " + name);
        System.out.println(" - Heal Amount: " + healAmount + " HP");
        System.out.println(" - Quantity: " + quantity + " charges left");
    }

    @Override
    public void use(Character character) {
        if (quantity > 0) {
            int oldHP = character.getHealthPoints();

            int newHP = oldHP + healAmount;
            character.setHealthPoints(Math.min(newHP, character.getHealthPointsMax()));

            int actualHeal = character.getHealthPoints() - oldHP;
            quantity--;

            System.out.println("\n--- " + character.getName() + " uses a " + this.name + " ---");
            System.out.println(character.getName() + " drinks " + this.name + "!");
            System.out.println("Health restored: " + oldHP + " → " + character.getHealthPoints() + " (+" + actualHeal + ")");
            System.out.println(this.name + " remaining: " + quantity);
        } else {
            System.out.println("\n" + this.name + " is empty! Cannot heal " + character.getName());
        }
    }
}
