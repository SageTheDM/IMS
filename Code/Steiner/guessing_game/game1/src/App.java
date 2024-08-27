import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = -1000;
        int maxRange = 1000;

        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int numberOfTries = 0;
        int inputNumber;

        // System.out.println("Number for the dev to check if the games is working: " +
        // randomNumber);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + minRange + " and " + maxRange + ".");
        System.out.println("Try to guess the number.");

        do {
            System.out.print("Enter your guess: ");
            inputNumber = scanner.nextInt();
            numberOfTries++;

            if (inputNumber < randomNumber) {
                System.out.println("The number is higher. Try again. (" + numberOfTries + " Try)");
            } else if (inputNumber > randomNumber) {
                System.out.println("The number is lower. Try again. (" + numberOfTries + " Try)");
            } else {
                System.out.println(
                        "Congratulations! You guessed the number " + randomNumber + " in " + numberOfTries + " tries.");
            }
        } while (inputNumber != randomNumber);
        if (numberOfTries == 1) {
            System.out.println("No offense but are you sure you didn't cheat?");
        }

        scanner.close();
    }
}
