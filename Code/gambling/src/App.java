import java.util.Random;
import java.util.Scanner;

public class App {
    public static int Budget = 1000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Coinflip, 2. Blackjack, 3. Roulette");
            int input = getInput();
            switch (input) {
                case 1:
                    playCoinflip();
                    break;
                case 2:
                    playBlackjack();
                    break;
                case 3:
                    playRoulette();
                    break;
                default:
                    System.out.println("Error: enter a valid code");
                    break;
            }
        }
    }

    public static int getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return scan.nextInt();
    }

    public static void playCoinflip() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            System.out.print("Enter your bet: ");
            int bet = scan.nextInt();
            if (bet > Budget) {
                System.out.println("You don't have enough money.");
                return;
            }

            System.out.print("Enter 1 for heads or 2 for tails: ");
            int choice = scan.nextInt();
            int result = random.nextInt(2) + 1;

            if (choice == result) {
                Budget += bet;
                System.out.println("You won!");
            } else {
                Budget -= bet;
                System.out.println("You lost.");
            }
            printBudget();
        }
    }

    public static void playBlackjack() {
        // Placeholder for Blackjack game logic
        System.out.println("Blackjack game coming soon...");
        // Update budget here based on game result
        printBudget();
    }

    public static void playRoulette() {
        // Placeholder for Roulette game logic
        System.out.println("Roulette game coming soon...");
        // Update budget here based on game result
        printBudget();
    }

    public static void printBudget() {
        System.out.println("Current Budget: $" + Budget);
    }
}
