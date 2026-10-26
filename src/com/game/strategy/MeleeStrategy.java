
package com.game.strategy;

public class MeleeStrategy implements AttackStrategy {

    @Override
    public int executeAttack() {
        System.out.println("⚔️ Enemy attacks with a sword!");
        return 25;
    }

    @Override
    public String getStrategyName() {
        return "Melee Attack";
    }
}
