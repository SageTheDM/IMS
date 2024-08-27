import java.util.Random;
import java.util.Scanner;

public class App {
    // Board chars
    public static final int BLANK = 0; // ' '
    public static final int WATER = 1; // 'O'
    public static final int SHIP = 2; // 'X'
    public static final int SUNK = 3; // 'S'
    public static final int HIDDEN_SHIP = 4; // ' '
    public static final int REVEALED_SHIP = 5; // 'R'

    // board[vertical desc --> y][horizontal left to right --> x]
    public static int[][] board = new int[10][10];

    // Array where the ships are stored
    private static int[] shipX = new int[10];
    private static int[] shipY = new int[10];
    private static boolean[] shipDirection = new boolean[10];
    private static int[] shipLength = new int[10];

    // Number of shots fired
    public static int firedShot = 0;
    public static boolean game = true;

    public static void main(String[] args) {
        boolean areShipsRevealed = false;
        // Explanation rules
        initializeGame();
        do {
            printBoard();
            System.out.println("Where do you want to shoot? (e.g., A5 or ? for a tip or -1 to end the game) ");
            String input = getCoordinates();

            switch (input) {
                case "-1":
                    game = false;
                    break;
                case "?":
                    revealHiddenShips();
                    areShipsRevealed = true;
                    break;
                default:
                    // The Lines 47-49 should be deactivated while debugging to make it easier
                    if (areShipsRevealed) {
                        hideRevealedShips();
                    }
                    handleShot(input);
                    break;
            }
        } while (game);
    }

    // Handles the player's shot input, validates it, and processes the shot.
    private static void handleShot(String input) {
        try {
            char xChar = input.toLowerCase().charAt(0);
            int y = Integer.parseInt(input.substring(1)) - 1;
            int x = xChar - 'a';
            if (isInputValid(x, y)) {
                String result = shot(x, y);
                System.out.println(result);
                System.out.println("Number of fired shots: " + firedShot);
                if (allShipSunk()) {
                    printBoard();
                    System.out.println("All ships have been sunk" + "\nYou won the game\n");
                    printBoard();
                    game = false;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid coordinate (e.g., A5).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid coordinate (e.g., A5).");
        }
    }

    // Reveals the positions of hidden ships on the board.
    private static void revealHiddenShips() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == HIDDEN_SHIP) {
                    board[i][j] = REVEALED_SHIP;
                }
            }
        }
    }

    // Hides the previously revealed ships on the board.
    private static void hideRevealedShips() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == REVEALED_SHIP) {
                    board[i][j] = HIDDEN_SHIP;
                }
            }
        }
    }

    // Initializes the game by setting up the board and randomly placing ships.
    private static void initializeGame() {
        // Fill board with blanks
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BLANK;
            }
        }

        // Place ships randomly
        Random random = new Random();
        int i = 0;
        int[] ships = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
        for (int shipSize : ships) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                boolean direction = random.nextBoolean();
                if (isValidPlacement(x, y, shipSize, direction)) {
                    shipLength[i] = shipSize;
                    shipX[i] = x;
                    shipY[i] = y;
                    shipDirection[i] = direction;

                    i++;
                    placeShip(x, y, shipSize, direction);
                    placed = true;
                }
            }
        }
    }

    // Validates the placement of a ship on the board.
    private static boolean isValidPlacement(int x, int y, int shipSize, boolean direction) {
        if (!isWithinBounds(x, y, shipSize, direction)) {
            return false;
        }

        if (doesOverlap(x, y, shipSize, direction)) {
            return false;
        }

        return hasSpaceOfWater(x, y, shipSize, direction);
    }

    // Checks if the ship placement is within the board boundaries.
    private static boolean isWithinBounds(int x, int y, int shipSize, boolean direction) {
        if (direction) {
            return x >= 0 && x + shipSize <= 10 && y >= 0 && y < 10;
        } else {
            return y >= 0 && y + shipSize <= 10 && x >= 0 && x < 10;
        }
    }

    // Checks if the ship placement overlaps with existing ships.
    private static boolean doesOverlap(int x, int y, int shipSize, boolean direction) {
        for (int i = 0; i < shipSize; i++) {
            int row = direction ? y : y + i;
            int col = direction ? x + i : x;

            if (board[row][col] != BLANK) {
                return true; // Overlaps with existing ship
            }
        }
        return false;
    }

    // Ensures that the ship has a space of water around it.
    private static boolean hasSpaceOfWater(int x, int y, int shipSize, boolean direction) {
        for (int i = 0; i < shipSize; i++) {
            int row = direction ? y : y + i;
            int col = direction ? x + i : x;

            for (int j = row - 1; j <= row + 1; j++) {
                for (int k = col - 1; k <= col + 1; k++) {
                    if (j >= 0 && j < 10 && k >= 0 && k < 10 && board[j][k] != BLANK) {
                        return false; // Adjacent cell is not water
                    }
                }
            }
        }
        return true; // Has space of water
    }

    // Places a ship on the board at the specified coordinates.
    private static void placeShip(int x, int y, int shipSize, boolean direction) {
        if (direction) {
            for (int i = 0; i < shipSize; i++) {
                board[y][x + i] = HIDDEN_SHIP;
            }
        } else {
            for (int i = 0; i < shipSize; i++) {
                board[y + i][x] = HIDDEN_SHIP;
            }
        }
    }

    // Gets coordinates input from the user.
    private static String getCoordinates() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    // Validates the input coordinates.
    private static boolean isInputValid(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    // Processes a shot at the specified coordinates and returns the result.
    private static String shot(int x, int y) {
        switch (board[y][x]) {
            case BLANK:
                board[y][x] = WATER;
                firedShot++;
                return "Miss!";
            case WATER:
                return "Already shot this field!";
            case HIDDEN_SHIP:
            case REVEALED_SHIP:
                board[y][x] = SHIP;
                firedShot++;
                if (isShipSunk(x, y)) {
                    sinkShip(x, y);
                    return "You sunk a ship!";
                } else {
                    return "You hit a ship!";
                }
            default:
                return "Invalid state!";
        }
    }

    // Sinks a ship by marking all its parts as sunk.
    private static void sinkShip(int x, int y) {
        for (int i = 0; i < shipX.length; i++) {
            int startX = shipX[i];
            int startY = shipY[i];
            int length = shipLength[i];
            boolean direction = shipDirection[i]; // true for horizontal, false for vertical

            // Check if the current shot is part of this ship
            if (direction) {
                // Horizontal ship
                if (y == startY && x >= startX && x < startX + length) {
                    // Mark all parts of the ship as sunk
                    for (int j = 0; j < length; j++) {
                        board[startY][startX + j] = SUNK;
                    }

                    for (int j = 0; j < length; j++) {
                        placeWaterAroundShip(startX + j, startY);
                    }
                    return;
                }
            } else {
                // Vertical ship
                if (x == startX && y >= startY && y < startY + length) {
                    // Mark all parts of the ship as sunk
                    for (int j = 0; j < length; j++) {
                        board[startY + j][startX] = SUNK;
                    }

                    for (int j = 0; j < length; j++) {
                        placeWaterAroundShip(startX, startY + j);
                    }
                    return;
                }
            }
        }
    }

    // Checks if a ship at the specified coordinates is completely sunk.
    private static boolean isShipSunk(int x, int y) {
        for (int i = 0; i < shipX.length; i++) {
            int startX = shipX[i];
            int startY = shipY[i];
            int length = shipLength[i];
            boolean direction = shipDirection[i]; // true for horizontal, false for vertical

            // Check if the current shot is part of this ship
            if (direction) {
                // Horizontal ship
                if (y == startY && x >= startX && x < startX + length) {
                    // Check all parts of the ship
                    for (int j = 0; j < length; j++) {
                        if (board[startY][startX + j] != SHIP && board[startY][startX + j] != SUNK) {
                            return false; // If any part is not hit, the ship is not sunk
                        }
                    }
                    return true; // All parts are hit, the ship is sunk
                }
            } else {
                // Vertical ship
                if (x == startX && y >= startY && y < startY + length) {
                    // Check all parts of the ship
                    for (int j = 0; j < length; j++) {
                        if (board[startY + j][startX] != SHIP && board[startY + j][startX] != SUNK) {
                            return false; // If any part is not hit, the ship is not sunk
                        }
                    }
                    return true; // All parts are hit, the ship is sunk
                }
            }
        }
        return false; // If the shot is not part of any ship (shouldn't happen in a valid game)
    }

    // Prints the current state of the board to the console.
    private static void printBoard() {
        System.out.println("   | A | B | C | D | E | F | G | H | I | J |");
        System.out.println("--------------------------------------------");
        char[] symbols = { ' ', 'O', 'X', 'S', ' ', 'R' };

        for (int i = 0; i < board.length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + " |");
            } else {
                System.out.print(" " + (i + 1) + "|");
            }
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + symbols[board[i][j]] + " |");
            }
            System.out.println("\n--------------------------------------------");
        }
    }

    // Places water around a sunk ship to mark its surrounding area.
    private static void placeWaterAroundShip(int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10 && board[i][j] == BLANK) {
                    board[i][j] = WATER;
                }
            }
        }
    }

    // Checks if all ships on the board are sunk.
    private static boolean allShipSunk() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == HIDDEN_SHIP || board[i][j] == REVEALED_SHIP) {
                    return false; // Found a ship that is not sunk
                }
            }
        }
        return true; // All ships are sunk
    }
}
