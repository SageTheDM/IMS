import java.util.Random;
import java.util.Scanner;

public class App {
    public static final int SIZE = 100;
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int score = 0;

    public static void main(String[] args) {
        boolean isGameRunning = true;
        startGame(isGameRunning);
    }

    /**
     * Displays options before the game starts.
     * Options include viewing rules, points information, starting the game, or
     * ending the game.
     */
    public static void startGame(boolean isGameRunning) {
        while (isGameRunning) {
            System.out.println("Options:");
            System.out.println("1. Rules");
            System.out.println("2. Points");
            System.out.println("0. Start the game");
            System.out.println("-1. End the game");

            int choice = getInput("Enter your choice");

            switch (choice) {
                case 1:
                    displayRules();
                    break;
                case 2:
                    displayPoints();
                    break;
                case 0:
                    playGame();
                    break;
                case -1:
                    isGameRunning = false;
                    endGame("Game ended before starting", 0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * Displays the rules of the game.
     */
    public static void displayRules() {
        System.out.println("Game Rules:");
        System.out.println("1. You start at position 0 on a board of size " + SIZE + ".");
        System.out.println("2. Your goal is to reach the end of the board without hitting any mines.");
        System.out.println("3. Mines are randomly placed on the board.");
        System.out.println("4. You can move a maximum of 6 spaces in each turn.");
        System.out.println("5. Hitting a mine ends the game.");
        System.out.println("6. Reaching the last space wins the game.");
    }

    /**
     * Displays information about the points system in the game.
     */
    public static void displayPoints() {
        System.out.println("Points Information:");
        System.out.println("1. Start with a score of 0.");
        System.out.println("2. Each correct move earns 5 points.");
        System.out.println("3. Using a tip deducts 10 points.");
        System.out.println("4. Final score is (2 * roundsSurvived + score).");
        System.out.println("5. Winning grants a bonus of 50 points.");
    }

    /**
     * Initiates the game, allowing the player to play.
     */
    public static void playGame() {
        int numMines = getInput("How many mines should be placed on the board");
        boolean[] board = new boolean[SIZE];
        boolean gameRun = true;
        int playerPos = 1;
        int roundsSurvived = 0;

        placeMines(numMines, board);

        while (gameRun) {
            int move = getInput("How many spaces do you want to move? (Max 6, 7 for a tip, 0 to quit)");

            if (!isValidMove(move)) {
                System.out.println("Error: Out of bounds");
                continue;
            }

            if (move == 0) {
                System.out.println("Bye Bye");
                break;
            } else if (move == 7) {
                giveTip(playerPos, board);
                score -= 10; // Deduct 10 points for using a tip
                continue;
            }

            if (board[playerPos]) {
                gameRun = false;
                endGame("You hit a mine and exploded", roundsSurvived);
                break;
            }

            if (isWinningPosition(playerPos, move, board)) {
                gameRun = false;
                endGame("Congratulations! You reached the end and won the game!", roundsSurvived);
                break;
            }

            score += 5; // Gain 5 points for a right move
            roundsSurvived++;
            playerPos += move;

            System.out.println("You're on space: " + playerPos + " | Score: " + score);
        }
    }

    /**
     * Obtains user input with a given message.
     * 
     * @param message The message to display when prompting for input.
     * @return The user's input.
     */
    public static int getInput(String message) {
        System.out.print(message + " ");
        return scanner.nextInt();
    }

    /**
     * Places mines on the game board.
     * 
     * @param numMines The number of mines to be placed.
     * @param board    The game board.
     */
    public static void placeMines(int numMines, boolean[] board) {
        for (int i = 0; i < numMines; i++) {
            int randomPos = rand.nextInt(SIZE);
            board[randomPos] = true;
        }
    }

    /**
     * Checks if a move is valid.
     * 
     * @param move The move to be checked.
     * @return True if the move is valid, false otherwise.
     */
    public static boolean isValidMove(int move) {
        return move >= 0 && move <= 6 || move == 7;
    }

    /**
     * Checks if the player is in a winning position.
     * 
     * @param playerPos The current position of the player.
     * @param move      The move made by the player.
     * @param board     The game board.
     * @return True if the player is in a winning position, false otherwise.
     */
    public static boolean isWinningPosition(int playerPos, int move, boolean[] board) {
        return playerPos == SIZE - 1 || playerPos + move >= SIZE;
    }

    /**
     * Provides a tip to the player about the nearest bomb.
     * 
     * @param playerPos The current position of the player.
     * @param board     The game board.
     */
    public static void giveTip(int playerPos, boolean[] board) {
        int rightDistance = findNearestBombDistance(playerPos, board);

        if (rightDistance == -1) {
            System.out.println("Tip: No bombs nearby, you're safe!");
        } else {
            System.out.println("Tip: The nearest bomb is on field " + rightDistance + ".");
        }
    }

    /**
     * Finds the distance to the nearest bomb in the forward direction.
     * 
     * @param playerPos The current position of the player.
     * @param board     The game board.
     * @return The distance to the nearest bomb, or -1 if no bomb is found in the
     *         given direction.
     */
    public static int findNearestBombDistance(int playerPos, boolean[] board) {
        for (int i = playerPos; i < SIZE; i++) {
            if (board[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ends the game and displays the final message.
     * 
     * @param message        The final message to be displayed.
     * @param roundsSurvived The number of rounds survived.
     */
    public static void endGame(String message, int roundsSurvived) {
        System.out.println(message);
        System.out.println("You survived " + roundsSurvived + " rounds");
        int finalScore = calculateFinalScore(roundsSurvived);
        System.out.println("Final Score: " + finalScore);
    }

    /**
     * Calculates the final score based on rounds survived and additional bonuses.
     * 
     * @param roundsSurvived The number of rounds survived.
     * @return The final calculated score.
     */
    public static int calculateFinalScore(int roundsSurvived) {
        int baseScore = 2 * roundsSurvived + score;
        if (isWinningPosition(SIZE - 1, 0, new boolean[SIZE])) {
            // If the player wins, add a bonus of 50 points
            return baseScore + 50;
        } else {
            return baseScore;
        }
    }
}
