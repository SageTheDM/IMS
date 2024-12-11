public class Game {
    private Board board;

    public Game() {
        board = new Board(5); // Example grid size
    }

    public void start() {
        // Example game loop
        if (board.isWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("Game continues.");
        }
    }
}