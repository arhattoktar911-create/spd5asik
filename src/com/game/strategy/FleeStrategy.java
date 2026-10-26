
package com.game.strategy;

public class FleeStrategy implements AttackStrategy {

    @Override
    public int executeAttack() {
        System.out.println("🏃 Enemy tries to escape!");
        return 0;
    }

    @Override
    public String getStrategyName() {
        return "Flee";
    }
}
