import java.util.Random;

import javax.swing.JOptionPane;

public class Testcode {
    public static void main(String[] args) {
        System.out.println("A code request you have made,");
        System.out.println("Fear not, for I am here to aid.");
        System.out.println("In Java, a language so grand,");
        System.out.println("I'll lend you a helping hand.");

        // Creating a Random object
        Random random = new Random();
        
        // Define the range for x, y and z
        int minRange = -10000;
        int maxRange = 10000;

        // Generate random values for x and y within the specified range
        int x = random.nextInt(maxRange - minRange + 1) + minRange;
        int y = random.nextInt(maxRange - minRange + 1) + minRange;
        int z = random.nextInt(maxRange - minRange + 1) + minRange;

        int sum = x + y + z;

        System.out.println("The sum of " + x + " " + y + " and " + z + " is: " + sum);

        System.out.println("May the code be with you!");
    
        // Testing Inputs with a gap text

         // Display a popup dialog and get user input
        String a = JOptionPane.showInputDialog("Please enter a verb (-ing):");
        String b = JOptionPane.showInputDialog("Please enter a location:");

        if ((a == null || a.trim().isEmpty()) && (b == null || b.trim().isEmpty())) {
            System.out.println("No words entered or both canceled.");
        } else if (a == null || a.trim().isEmpty()) {
            System.out.println("The verb was not entered or canceled.");
        } else if (b == null || b.trim().isEmpty()) {
            System.out.println("The location was not entered or canceled.");
        } else {
            System.out.println("They were " + a + " throw a " + b );
        }
    }
}
