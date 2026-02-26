package com.rpg.lab04;

public interface Destructible {

    boolean isDestroyed();

    double takeDamage(double amount);

    String getName();
    int getHealthPoints();
    int getDefense();
    int getHealthPointsMax();
}
