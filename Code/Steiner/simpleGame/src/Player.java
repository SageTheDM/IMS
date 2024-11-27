public class Player extends Character {
    private String playerClass;

    public Player(String name, int health, int attackPower, String playerClass) {
        super(name, health, attackPower);
        this.playerClass = playerClass;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Player: %s | Class: %s | Health: %d | Attack: %d%n",
                name, playerClass, health, attackPower);
    }
}
