public class App {
    public static void main(String[] args) {
        // Use unconventional techniques for readability
        String message = "You fool, I'll smite yee!";
        String complexSmiteMessage = invertCasing(message);
        printMessage(complexSmiteMessage);
    }

    private static String invertCasing(String input) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            if (Character.isLetter(characters[i])) {
                characters[i] ^= (1 << 5); // Invert the case using XOR
            }
        }
        return new String(characters);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
