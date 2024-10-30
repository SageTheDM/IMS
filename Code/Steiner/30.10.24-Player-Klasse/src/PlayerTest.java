public class PlayerTest {
    public static void main(String[] args) {
        Player[] players = new Player[20];
        String[] names = { "Eva", "Fritz", "Anna", "Luca", "Sara", "Max", "Zoe", "Leo", "Nina", "Tom",
                "Ella", "Jake", "Mia", "Liam", "Sophie", "Noah", "Emma", "Ben", "Olivia", "Eli" };
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i]);
        }
        for (Player player : players) {
            System.out.println(player.getId() + " " + player.getName());
        }
    }
}