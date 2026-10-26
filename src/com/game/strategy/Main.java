
package com.game.strategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EnemyAI enemy = new EnemyAI(
                "Dark Knight",
                new MeleeStrategy()
        );

        int playerHealth = 100;
        int round = 1;

        System.out.println("==============================");
        System.out.println("     GAME AI BATTLE SIMULATOR");
        System.out.println("==============================");

        while (playerHealth > 0 && enemy.isAlive()) {

            System.out.println("\n========== ROUND " + round + " ==========");
            System.out.println("Your HP: " + playerHealth);
            System.out.println("Enemy HP: " + enemy.getHealth());

            System.out.println("\nChoose enemy strategy:");
            System.out.println("1. Melee Attack (25 damage)");
            System.out.println("2. Ranged Attack (15 damage)");
            System.out.println("3. Flee (0 damage)");
            System.out.println("4. Exit Game");

            System.out.print("\nYour choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> enemy.setStrategy(new MeleeStrategy());
                case 2 -> enemy.setStrategy(new RangedStrategy());
                case 3 -> enemy.setStrategy(new FleeStrategy());
                case 4 -> {
                    System.out.println("Game closed.");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice!");
                    continue;
                }
            }

            int damage = enemy.performAction();
            playerHealth = Math.max(0, playerHealth - damage);

            System.out.println("Your remaining HP: " + playerHealth);

            if (playerHealth == 0) {
                System.out.println("\nGAME OVER! Enemy wins!");
                break;
            }

            System.out.println("\nYour turn!");
            System.out.println("You attack the enemy!");
            enemy.takeDamage(20);

            if (!enemy.isAlive()) {
                System.out.println("\nVICTORY! You defeated the enemy!");
                break;
            }

            round++;
        }

        System.out.println("\n========== BATTLE FINISHED ==========");
        scanner.close();
    }
}
