import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Position player = new Position();
        player.x = 0;
        player.y = 0;

        while (true) {
            player.printPosition(player);
            int direction = whereToMove(player);
            int distance = howFar(player);
            switch (direction) {
                case 1:
                    player.goUp(distance);
                    break;
                case 2:
                    player.goRight(distance);
                    break;
                case 3:
                    player.goDown(distance);
                    break;
                case 4:
                    player.goLeft(distance);
                    break;

                default:
                    System.out.println("Was not a valid direction || distance");
                    break;
            }
        }
    }

    public static int whereToMove(Position player) {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Where do you want to move (1 up, 2 right, 3 down, 4 left)");
            try {
                input = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Input was not an int");
            }
        }
        return input;
    }

    public static int howFar(Position player) {
        Scanner scan = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("How far?");
            try {
                input = scan.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Input was not an int");
            }
        }
        return input;
    }
}
