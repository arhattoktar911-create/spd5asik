
package com.game.strategy;

public class RangedStrategy implements AttackStrategy {

    @Override
    public int executeAttack() {
        System.out.println("🏹 Enemy shoots an arrow!");
        return 15;
    }

    @Override
    public String getStrategyName() {
        return "Ranged Attack";
    }
}
