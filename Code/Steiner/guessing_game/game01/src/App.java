import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int numberOfTries = 0;
        int maxNumber = 100;
        int randomNumber = random.nextInt(maxNumber) + 1;
        int userinput = 0;

        System.out.println("Number for the dev to check if the games is working: " + randomNumber);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + 0 + " and " + maxNumber + ".");
        System.out.println("Try to guess the number.");

        while (true) {
            numberOfTries++;
            System.out.println(numberOfTries + ". Try");
            userinput = scan.nextInt();

            if (randomNumber > userinput) {
                System.out.println("Lmao no the number is bigger");
            } else if (randomNumber == userinput) {
                System.out.println("You got the right number my brother");
                System.out.println("You only needed " + numberOfTries + " tries");
                break;
            } else {
                System.out.println("No the number is smaller");
            }
        }

        if (numberOfTries == 1) {
            System.out.println("No offense but are you sure you didn't cheat?");
        }
        scan.close();
    }

}
