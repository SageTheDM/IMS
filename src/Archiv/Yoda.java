import java.util.Random;

public class Yoda {
    public static void main(String[] args) {
        // Print text

        System.out.println("A code request you have made,");
        System.out.println("Fear not, for I am here to aid.");
        System.out.println("In Java, a language so grand,");
        System.out.println("I'll lend you a helping hand.");

        // Creating a Random object
        Random random = new Random();

        // Define the range for xx, yy and zz
        int minRange = -10000;
        int maxRange = 10000;

        // Generate random values for xx, zz and yy within the specified range
        int xx = random.nextInt(maxRange - minRange + 1) + minRange;
        int yy = random.nextInt(maxRange - minRange + 1) + minRange;
        int zz = random.nextInt(maxRange - minRange + 1) + minRange;

        int sum = xx + yy + zz;

        System.out.println("The sum of " + xx + ", " + yy + " and " + zz + " is: " + sum);

        System.out.println("May the code be with you!");
    }
}