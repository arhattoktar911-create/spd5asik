
package com.game.strategy;

import java.util.Objects;

public class EnemyAI {

    private final String name;
    private int health;
    private AttackStrategy strategy;

    public EnemyAI(String name, AttackStrategy strategy) {
        this.name = name;
        this.health = 100;
        setStrategy(strategy);
    }

    public void setStrategy(AttackStrategy newStrategy) {
        this.strategy = Objects.requireNonNull(newStrategy);
        System.out.println("Strategy changed to: "
                + strategy.getStrategyName());
    }

    public int performAction() {
        System.out.println("\n" + name + "'s turn!");
        int damage = strategy.executeAttack();
        System.out.println("Damage: " + damage);
        return damage;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
        System.out.println(name + " received " + damage + " damage!");
        System.out.println(name + " HP: " + health);
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
