import java.util.Scanner;

public class App {
    private static String[] playerNames;
    private static int[] playerPositions;
    private static int currentPlayerIndex = 0;
    private static int[] ladderSnakes = new int[130];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startGame();
        while (playTurn())
            System.out.println("=====================================");
        scanner.close();
    }

    // Initialize the game
    private static void startGame() {
        System.out.println("Welcome to Snakes and Ladders!");
        displayRules();
        setPlayerNames();
        determinePlayerOrder();
        playerPositions = new int[playerNames.length];
        initializeLadderSnakes();
    }

    // Placement of leadders and snakes
    private static void initializeLadderSnakes() {
        ladderSnakes[3] = 49;
        ladderSnakes[5] = 26;
        ladderSnakes[14] = 9;
        ladderSnakes[21] = 63;
        ladderSnakes[47] = 24;
        ladderSnakes[52] = 74;
        ladderSnakes[54] = 21;
        ladderSnakes[58] = 82;
        ladderSnakes[66] = 88;
        ladderSnakes[89] = 61;
        ladderSnakes[94] = 122;
        ladderSnakes[99] = 116;
        ladderSnakes[101] = 76;
        ladderSnakes[104] = 126;
        ladderSnakes[110] = 91;
        ladderSnakes[128] = 112;
    }

    // the rules
    private static void displayRules() {
        System.out.println(
                "Rules:\n" +
                        "1. The game is played on a board with 130 squares numbered from 1 to 130.\n" +
                        "2. The goal is to reach square 130 exactly.\n" +
                        "3. Each player takes turns rolling a six-sided die.\n" +
                        "4. Move forward the number of squares equal to the dice roll.\n" +
                        "5. If a player lands on a square with a ladder, they climb the ladder to the top.\n" +
                        "6. If a player lands on a square with the head of a snake, they slide down to the tail.\n" +
                        "7. The first player to reach square 130 wins the game!\n");
    }

    // Name input and number of Players
    private static void setPlayerNames() {
        int numPlayers = getUserInt("Enter the number of players: ");
        playerNames = new String[numPlayers];
        System.out.println("Enter the names of the players:");
        for (int i = 0; i < numPlayers; i++) {
            playerNames[i] = getUserName("Enter name for player " + (i + 1) + ": ");
        }
        System.out.println("Player names set!");
    }

    // Determine player order
    private static void determinePlayerOrder() {
        if (playerNames.length > 1) {
            int maxIndex = determineMaxRollIndex();
            if (maxIndex != 0)
                swapPlayers(0, maxIndex);
            displayPlayerOrder();
        }
    }

    // who rolled the highest
    private static int determineMaxRollIndex() {
        int maxIndex = 0;
        int maxRoll = -1;
        for (int i = 0; i < playerNames.length; i++) {
            int roll;
            do {
                roll = getUserInt(playerNames[i] + ", what did you roll?");
                if (!isValidMove(roll))
                    System.out.println("Invalid move. Try again.");
            } while (!isValidMove(roll));
            if (roll > maxRoll) {
                maxRoll = roll;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Display the order
    private static void displayPlayerOrder() {
        System.out.println("Player order after determining:");
        for (int i = 0; i < playerNames.length; i++)
            System.out.println((i + 1) + ". " + playerNames[i]);
    }

    private static void swapPlayers(int index1, int index2) {
        String tempName = playerNames[index1];
        playerNames[index1] = playerNames[index2];
        playerNames[index2] = tempName;
    }

    private static boolean playTurn() {
        // Start at 0 at the begining of the first turn placed onto the board
        if (playerPositions[currentPlayerIndex] == 0)
            playerPositions[currentPlayerIndex] = 1;

        boolean extraTurn = false;

        do {
            displayPlayerStatus();
            int move = getValidMove();
            if (move == -1) {
                handleRageQuit();
                break;
            } else if (move == -2) {
                handleGameEnd();
                return false;
            } else {
                System.out.println(playerNames[currentPlayerIndex] + " rolled a " + move + ".");
                updatePlayerPosition(move);
                int destination = handleSpecialFields();

                if (destination != playerPositions[currentPlayerIndex]) {
                    System.out.print(
                            playerNames[currentPlayerIndex] + " goes from " + playerNames[currentPlayerIndex] + " to "
                                    + destination + ". ");

                    if (playerPositions[currentPlayerIndex] < destination) {
                        System.out.println("Climb the ladder!");
                    } else {
                        System.out.println("Slide the snakes");
                    }

                    playerPositions[currentPlayerIndex] = destination;
                }
                printPlayerPositions();

                if (playerPositions[currentPlayerIndex] == 130) {
                    System.out.println(playerNames[currentPlayerIndex] + " wins the game!");
                    return false;
                }

                extraTurn = (move == 6); // Check if the player rolled a 6 for an additional turn
                if (!extraTurn) {
                    currentPlayerIndex = (currentPlayerIndex + 1) % playerNames.length;
                }
            }
        } while (extraTurn);

        return true;
    }

    // display all relevant information
    private static void displayPlayerStatus() {
        System.out.println(
                "Current position for " + playerNames[currentPlayerIndex] + ": " + playerPositions[currentPlayerIndex]);
        System.out.println("Enter -1 for a ragequit");
        System.out.println("Enter -2 to end the game for all.");
        System.out.println(playerNames[currentPlayerIndex] + "'s turn.");
        // int consequences = mostOptimalMove(currentPlayerIndex);
        // if (consequences != 0) {
        System.out.println("The most optimal roll is: " + mostOptimalMove(playerPositions[currentPlayerIndex]));
        // }
    }

    // test if it is a valid move
    private static int getValidMove() {
        int move;
        boolean validMove;
        do {
            move = getUserInt("Enter the dice roll for " + playerNames[currentPlayerIndex] + ": ");
            if (move == -1 || move == -2) {
                return move;
            } else {
                validMove = isValidMove(move);
                if (!validMove)
                    System.out.println("Invalid move! Please try again.");
            }
        } while (!validMove);
        return move;
    }

    private static void handleRageQuit() {
        System.out.println("Player " + playerNames[currentPlayerIndex]
                + " ragequit. But that's not an option xD. Going back to position 1.");
        playerPositions[currentPlayerIndex] = 1;
    }

    private static void handleGameEnd() {
        System.out.println(playerNames[currentPlayerIndex]
                + " has ended the game");
        playerPositions[currentPlayerIndex] = -2;
        System.out.println("Game ended. Thanks for playing!");
    }

    private static void updatePlayerPosition(int move) {
        int newPosition = playerPositions[currentPlayerIndex] + move;

        if (newPosition == 130) {
            playerPositions[currentPlayerIndex] = newPosition;
            System.out.println(playerNames[currentPlayerIndex] + " wins the game!");
        } else if (newPosition > 130) {
            int overshoot = newPosition - 130;
            playerPositions[currentPlayerIndex] = 130 - overshoot;
            System.out.println("Oops! " + playerNames[currentPlayerIndex] + " overshot 130 and walked back.");
        } else {
            playerPositions[currentPlayerIndex] = newPosition;
        }
    }

    private static int handleSpecialFields() {
        int currentPosition = playerPositions[currentPlayerIndex];

        for (int i = 0; i < ladderSnakes.length; i++) {
            if (currentPosition == i && ladderSnakes[i] != 0) {
                int destination = ladderSnakes[i];
                System.out.print(playerNames[currentPlayerIndex] + " goes from " + currentPosition + " to "
                        + destination + ". ");

                if (currentPosition < destination) {
                    System.out.println("Climb the ladder!");
                } else {
                    System.out.println("Slide the snakes");
                }

                return destination;
            }
        }

        // If no ladder or snake is encountered, return the current position
        return currentPosition;
    }

    private static void printPlayerPositions() {
        for (int i = 0; i < playerNames.length; i++)
            System.out.println(playerNames[i] + " Position: " + playerPositions[i] + " | ");
    }

    private static boolean isValidMove(int move) {
        return move >= 1 && move <= 6;
    }

    private static String getUserName(String prompt) {
        System.out.println(prompt);
        String name = scanner.next();
        return name;
    }

    private static int getUserInt(String prompt) {
        int number = 0;
        while (number == 0) {
            System.out.println(prompt);
            try {
                number = scanner.nextInt();
            } catch (Exception e) {
                number = 0;
                scanner.next();
            }
        }
        return number;
    }

    private static int mostOptimalMove(int currentPosition) {
        int mostOptimalRoll = 0;
        int maxPosition = currentPosition;

        // for (int i = 1; i <= 6; i++) {
        // int simulatedPosition = currentPosition + i;

        // // Check for ladder or snake at the simulated position
        // if (simulatedPosition < ladderSnakes.length &&
        // ladderSnakes[simulatedPosition] != 0) {
        // // Adjust simulated position without modifying ladderSnakes
        // simulatedPosition = ladderSnakes[simulatedPosition];
        // }

        // // Check if this roll leads to a position further ahead
        // if (simulatedPosition > maxPosition) {
        // maxPosition = simulatedPosition;
        // mostOptimalRoll = i;
        // }

        // System.out.println("If you roll a " + i + ", you land on: " +
        // simulatedPosition);
        // }

        // return mostOptimalRoll;
        // }

        int optimalRoll = 0;
        for (int i = 1; i <= 6; i++) {
            int simulatedPosition = currentPosition + i;

            // Check for ladder or snake at the simulated position
            for (int j = 0; j < ladderSnakes.length; j++) {
                if (simulatedPosition == j && ladderSnakes[j] != 0) {
                    // Adjust simulated position without modifying ladderSnakes
                    simulatedPosition = ladderSnakes[j];
                    break;
                }
            }

            if (simulatedPosition > maxPosition) {
                maxPosition = simulatedPosition;
                optimalRoll = i;
            }

            if (playerPositions[currentPlayerIndex] >= 124) {
                optimalRoll = 130 - playerPositions[currentPlayerIndex];
            }
        }
        return optimalRoll;
    }

}
