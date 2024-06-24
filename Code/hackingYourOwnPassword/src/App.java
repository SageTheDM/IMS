import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String end = "I am stupid";
        String secretPassword = "geheim";
        String userInput = "";
        int numberOfTriesRemaining = 10;
        boolean rightPassword = false;

        do {
            System.out.println("Please enter your password. You have " + numberOfTriesRemaining + " tries remaining"
                    + " alternetively write the following text to end the procees: " + end);
            userInput = scan.nextLine();
            numberOfTriesRemaining--;

            if (userInput.equalsIgnoreCase(end)) {
                break;
            }

            if (userInput.equals(secretPassword)) {
                rightPassword = true;
            }

        } while (!rightPassword && numberOfTriesRemaining >= 0);

        if (rightPassword) {
            System.out.println("Logged in into super extreme secret account!");
        } else if (userInput.equalsIgnoreCase(end)) {
            System.out.println("Login cancelled");
        } else {
            System.out.println("You're super secret account has been permanently looked, please do not call IT");
        }

    }
}
