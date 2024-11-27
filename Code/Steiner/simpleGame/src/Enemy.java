public class Enemy extends Character {
    private int maxHealth; // Store the original health value

    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
        this.maxHealth = health; // Initialize maxHealth to the starting health
    }

    public void resetHealth() {
        this.health = maxHealth; // Restore health to its original value
    }

    @Override
    public void displayInfo() {
        System.out.printf("Enemy: %s | Health: %d | Attack: %d%n",
                name, health, attackPower);
    }
}
