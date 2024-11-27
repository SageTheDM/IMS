import java.util.Random;
import java.util.Scanner;

public class FightingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Choose your class: Fighter, Ranger, Mage");
        String playerClass = scanner.nextLine();

        Player player;
        if (playerClass.equalsIgnoreCase("Fighter")) {
            player = new Player("Fighter", 100, 15, "Fighter");
        } else if (playerClass.equalsIgnoreCase("Ranger")) {
            player = new Player("Ranger", 75, 20, "Ranger");
        } else {
            player = new Player("Mage", 50, 30, "Mage");
        }

        // Enemy pool
        Enemy[] enemies = {
                new Enemy("Bear", 80, 10),
                new Enemy("Slime", 50, 5),
                new Enemy("Herr Steiner der Mächtige", 150, 25)
        };

        boolean playing = true;
        while (playing && player.isAlive()) {
            System.out.println("\nA new enemy appears!");
            Enemy enemy = enemies[random.nextInt(enemies.length)];
            enemy.resetHealth(); // Reset the enemy's health
            enemy.displayInfo();

            while (enemy.isAlive() && player.isAlive()) {
                System.out.println("\nChoose an action: Attack / Defend / Run");
                String action = scanner.nextLine();

                if (action.equalsIgnoreCase("Attack")) {
                    System.out.printf("You attack %s for %d damage!%n",
                            enemy.getName(), player.getAttackPower());
                    enemy.takeDamage(player.getAttackPower());

                    if (enemy.isAlive()) {
                        System.out.printf("%s attacks you for %d damage!%n",
                                enemy.getName(), enemy.getAttackPower());
                        player.takeDamage(enemy.getAttackPower());
                    } else {
                        System.out.printf("You defeated %s!%n", enemy.getName());
                    }
                } else if (action.equalsIgnoreCase("Defend")) {
                    System.out.println("You defend yourself and take less damage!");
                    int reducedDamage = Math.max(0, enemy.getAttackPower() / 2);
                    System.out.printf("%s attacks you for %d damage!%n",
                            enemy.getName(), reducedDamage);
                    player.takeDamage(reducedDamage);
                } else if (action.equalsIgnoreCase("Run")) {
                    System.out.println("You attempt to flee...");
                    if (random.nextBoolean()) {
                        System.out.println("You successfully escaped!");
                        break;
                    } else {
                        System.out.println("You failed to escape!");
                        System.out.printf("%s attacks you for %d damage!%n",
                                enemy.getName(), enemy.getAttackPower());
                        player.takeDamage(enemy.getAttackPower());
                    }
                } else {
                    System.out.println("Invalid action! Try again.");
                }

                System.out.printf("Your Health: %d | %s's Health: %d%n",
                        player.getHealth(), enemy.getName(), enemy.getHealth());
            }

            if (!player.isAlive()) {
                System.out.println("You have been defeated! Game over.");
                playing = false;
            } else if (!enemy.isAlive()) {
                System.out.println("Do you want to continue? (yes/no)");
                String continueGame = scanner.nextLine();
                if (continueGame.equalsIgnoreCase("no")) {
                    playing = false;
                }
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
