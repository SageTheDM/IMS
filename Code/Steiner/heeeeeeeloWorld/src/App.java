import java.util.Random;

public class App {
    public static void main(String[] args) {
        String helloWorldMessage = concatenateLetters(
                getH(), getE(), getL(), getL(), getO(),
                getComma(), getSpace(),
                getW(), getO(), getR(), getL(), getD(), getExclamation());

        printMessageWithFunnyLoop(helloWorldMessage);
    }

    private static String concatenateLetters(String... letters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : letters) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    private static String getH() {
        return "H";
    }

    private static String getE() {
        return "e";
    }

    private static String getL() {
        return "l";
    }

    private static String getO() {
        return "o";
    }

    private static String getComma() {
        return ",";
    }

    private static String getSpace() {
        return " ";
    }

    private static String getW() {
        return "W";
    }

    private static String getR() {
        return "r";
    }

    private static String getD() {
        return "d";
    }

    private static String getExclamation() {
        return "!";
    }

    private static void printMessageWithFunnyLoop(String message) {
        System.out.println(message);

        // Adding a funny and unnecessary loop
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int numHa = random.nextInt(5) + 2; // Randomly choose between 2 and 6 "ha"s
            for (int j = 0; j < numHa; j++) {
                System.out.print("ha");
            }
            System.out.print(" ");
        }
    }
}
