public class Position {
    int x;
    int y;

    void goLeft(int howFar) {
        x = x - howFar;
    }

    void goRight(int howFar) {
        x = x + howFar;
    }

    void goUp(int howFar) {
        y = y - howFar;
    }

    void goDown(int howFar) {
        y = y + howFar;
    }

    void printPosition(Position player) {
        System.out.println("Player Position: (" + player.x + "/" + player.y + ")");
    }
}
