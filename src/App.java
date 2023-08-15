import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("A code request you have made,");
        System.out.println("Fear not, for I am here to aid.");
        System.out.println("In Java, a language so grand,");
        System.out.println("I'll lend you a helping hand.");

        // Creating a Random object
        Random random = new Random();
        
        // Define the range for x and y
        int minRange = -1000;
        int maxRange = 1000;

        // Generate random values for x and y within the specified range
        int x = random.nextInt(maxRange - minRange + 1) + minRange;
        int y = random.nextInt(maxRange - minRange + 1) + minRange;

        int sum = x + y;

        System.out.println("Generated random x: " + x);
        System.out.println("Generated random y: " + y);
        System.out.println("The sum of " + x + " and " + y + " is: " + sum);

        System.out.println("May the code be with you!");
    }
}