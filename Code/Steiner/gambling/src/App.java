import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static int Budget = 0;
    public static boolean card[][] = new boolean[4][13];
    public static int turnCount = 0;
    public static final int MIN_TURNS = 3;
    public static final int MAX_TURNS = 10;

    public static void main(String[] args) {
        initializeBet();
        while (true) {
            System.out.println("1. Coinflip, 2. Blackjack, 3. Roulette");
            int input = getInput("Enter choice: ");
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

    public static void printRules() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Rules:");
        System.out.println("1. The goal is to get as close to 21 without exceeding it.");
        System.out.println("2. Aces can be 1 or 11, face cards are worth 10, and other cards are worth their number.");
        System.out.println("3. You start by placing a bet before receiving your first two cards.");
        System.out.println("4. Options:");
        System.out.println("   - Hit: Draw another card.");
        System.out.println("   - Stand: Keep your current hand.");
        System.out.println("   - Double Down: Double your bet and receive one more card.");
        System.out.println("   - Split: If you have two cards of the same value, split them into two hands.");
        System.out.println("5. The dealer will draw cards until they have at least 17 points.");
        System.out.println("6. Cards will be reshuffled after 3-10 turns.");
        System.out.println("Good luck!\n");
    }

    public static int getInput(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        return scan.nextInt();
    }

    public static void initializeBet() {
        Budget = getInput("With how much money do you want to play? ");
        printBudget();
    }

    public static void playCoinflip() {
        Random random = new Random();
        while (true) {
            int bet = enterBet();
            int choice = getInput("Enter 1 for heads or 2 for tails (0 to stop playing): ");
            int result = random.nextInt(2) + 1;
            if (choice == 0) {
                break;
            } else {
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
    }

    public static void playBlackjack() {
        ArrayList<Integer> playerHands = new ArrayList<>();
        ArrayList<Integer> playerAceCounts = new ArrayList<>();
        ArrayList<Integer> bets = new ArrayList<>();
        boolean dealerDone = false;

        printRules(); // Print the rules at the start of the Blackjack game
        shuffleCards(); // Initial shuffle

        while (true) {
            // Reshuffle if needed
            if (turnCount >= MIN_TURNS && turnCount <= MAX_TURNS
                    && turnCount % (new Random().nextInt(MAX_TURNS - MIN_TURNS + 1) + MIN_TURNS) == 0) {
                shuffleCards();
            }

            System.out.println("Starting new hand...");
            bets.clear();
            playerHands.clear();
            playerAceCounts.clear();

            bets.add(enterBet());
            playerHands.add(getCard());
            playerHands.set(0, playerHands.get(0) + getCard());
            playerAceCounts.add(0);

            for (int i = 0; i < playerHands.size(); i++) {
                boolean handDone = false;

                while (!handDone) {
                    System.out.println("Your hand " + (i + 1) + ": " + playerHands.get(i));
                    System.out.println("1. Hit 2. Stand 3. Double Down 4. Split");
                    int choice = getInput("Choose an action: ");

                    switch (choice) {
                        case 1: // Hit
                            playerHands.set(i, playerHands.get(i)
                                    + getCardWithAceHandling(playerHands.get(i), playerAceCounts.get(i)));
                            if (playerHands.get(i) > 21) {
                                System.out.println("You busted!");
                                Budget -= bets.get(i);
                                handDone = true;
                            }
                            break;
                        case 2: // Stand
                            handDone = true;
                            break;
                        case 3: // Double Down
                            if (bets.get(i) * 2 <= Budget) {
                                bets.set(i, bets.get(i) * 2);
                                playerHands.set(i, playerHands.get(i)
                                        + getCardWithAceHandling(playerHands.get(i), playerAceCounts.get(i)));
                                if (playerHands.get(i) > 21) {
                                    System.out.println("You busted!");
                                    Budget -= bets.get(i);
                                }
                                handDone = true;
                            } else {
                                System.out.println("Not enough budget to double down.");
                            }
                            break;
                        case 4: // Split
                            if (playerHands.size() < 4 && bets.get(i) * 2 <= Budget) {
                                int firstCard = playerHands.get(i) / 2; // Assuming the player has exactly two of the
                                                                        // same card value
                                int secondCard = playerHands.get(i) - firstCard;

                                if (firstCard == secondCard) {
                                    playerHands.set(i, firstCard + getCard());
                                    playerHands.add(secondCard + getCard());
                                    playerAceCounts.add(0);
                                    bets.add(bets.get(i));
                                    Budget -= bets.get(i); // Deduct the additional bet for the split
                                } else {
                                    System.out.println("Cannot split non-matching cards.");
                                }
                            } else {
                                System.out.println("Cannot split more hands or not enough budget.");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                }
            }

            // Dealer's turn
            int dealerHand = getCard();
            dealerHand += getCard();
            while (dealerHand < 17) {
                dealerHand += getCardWithAceHandling(dealerHand, 0);
            }
            dealerDone = true;

            // Determine winner
            for (int i = 0; i < playerHands.size(); i++) {
                if (playerHands.get(i) <= 21 && dealerHand <= 21) {
                    if (playerHands.get(i) > dealerHand) {
                        System.out.println("Hand " + (i + 1) + " wins!");
                        Budget += bets.get(i);
                    } else if (playerHands.get(i) < dealerHand) {
                        System.out.println("Hand " + (i + 1) + " loses.");
                        Budget -= bets.get(i);
                    } else {
                        System.out.println("Hand " + (i + 1) + " ties.");
                    }
                } else if (dealerHand > 21) {
                    System.out.println("Dealer busted! Hand " + (i + 1) + " wins!");
                    Budget += bets.get(i);
                } else if (playerHands.get(i) > 21) {
                    System.out.println("Hand " + (i + 1) + " busted.");
                    Budget -= bets.get(i);
                }
            }

            turnCount++;
            printBudget();
        }
    }

    public static void shuffleCards() {
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                card[x][y] = true;
            }
        }
        System.out.println("Cards shuffling...");
    }

    public static int getCard() {
        Random random = new Random();
        int cardValue = 0;

        do {
            int number = random.nextInt(13);
            int symbol = random.nextInt(4);

            if (card[symbol][number]) {
                card[symbol][number] = false;
                printCard(number, symbol);

                if (number == 0) { // Ace
                    return 11;
                } else if (number >= 10) { // Jack, Queen, King
                    return 10;
                } else { // Number cards (2-10)
                    return number + 1;
                }
            }
        } while (true);
    }

    public static int getCardWithAceHandling(int currentHand, int aceCount) {
        int cardValue = getCard();
        currentHand += cardValue;

        if (cardValue == 11) {
            aceCount++;
        }

        while (currentHand > 21 && aceCount > 0) {
            currentHand -= 10;
            aceCount--;
        }

        return currentHand;
    }

    public static void printCard(int card, int symbol) {
        String displayNumber;
        char displaySymbol;
        switch (symbol) {
            case 0:
                displaySymbol = '\u2665'; // Hearts
                break;
            case 1:
                displaySymbol = '\u2666'; // Diamonds
                break;
            case 2:
                displaySymbol = '\u2663'; // Clubs
                break;
            case 3:
                displaySymbol = '\u2660'; // Spades
                break;
            default:
                System.out.println("Error");
                displaySymbol = 0;
                break;
        }

        switch (card) {
            case 0:
                displayNumber = "A";
                break;
            case 10:
                displayNumber = "J";
                break;
            case 11:
                displayNumber = "Q";
                break;
            case 12:
                displayNumber = "K";
                break;
            default:
                displayNumber = String.valueOf(card + 1);
                break;
        }
        System.out.println("----");
        System.out.println("|" + displaySymbol + displayNumber + "|");
        System.out.println("----");
    }

    public static void playRoulette() {
        System.out.println("Roulette game coming soon...");
        printBudget();
    }

    public static void printBudget() {
        System.out.println("Current Budget: $" + Budget);
    }

    public static int enterBet() {
        while (true) {
            int bet = getInput("Enter your bet: ");
            if (bet <= Budget) {
                return bet;
            } else {
                System.out.println("You don't have enough money.");
            }
        }
    }
}
