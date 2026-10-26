# Assignment 5: Strategy Pattern (Game AI Behavior)

## Description
This project demonstrates the Strategy design pattern in Java (JDK 17).
It simulates a Game AI Enemy switching combat strategies dynamically based on runtime events (Ranged, Melee, Flee).

## How to Build and Run
1. Open the project in IntelliJ IDEA or terminal.
2. Compile and run `com.game.strategy.Main`.

## How to Add a New Strategy
1. Create a new class implementing `AttackStrategy` (e.g., `MagicStrategy`).
2. Implement the `executeAttack()` method.
3. Pass the new strategy instance to `EnemyAI#setStrategy()` at runtime without modifying existing context logic.