public class Board {
    private int gridSize;
    private Field[][] grid;

    public Board(int gridSize) {
        this.gridSize = gridSize;
        grid = new Field[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = new Field();
            }
        }
    }

    public void placeUnit(int x, int y) {
        if (!grid[x][y].isFieldOccupied()) {
            grid[x][y].setFieldOccupied(true);
            System.out.println("Unit placed at (" + x + ", " + y + ")");
        } else {
            System.out.println("Field is already occupied.");
        }
    }

    public void moveUnit(int fromX, int fromY, int toX, int toY) {
        if (grid[fromX][fromY].isFieldOccupied() && !grid[toX][toY].isFieldOccupied()) {
            grid[fromX][fromY].setFieldOccupied(false);
            grid[toX][toY].setFieldOccupied(true);
            System.out.println("Unit moved to (" + toX + ", " + toY + ")");
        } else {
            System.out.println("Invalid move.");
        }
    }

    public boolean isWon() {
        // Example condition: if any unit reaches the last row
        for (int j = 0; j < gridSize; j++) {
            if (grid[gridSize - 1][j].isFieldOccupied()) {
                return true;
            }
        }
        return false;
    }
}