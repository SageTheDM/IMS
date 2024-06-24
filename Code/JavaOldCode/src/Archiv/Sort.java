package Archiv;

import java.util.Random;

public class Sort {
    public static void main(String[] args) throws Exception {
        // Creating a Random object
        Random random = new Random();

        // Define the range for variables
        int minRange = -10000;
        int maxRange = 10000;

        // Generate random values
        int a = random.nextInt(maxRange - minRange + 1) + minRange;
        int b = random.nextInt(maxRange - minRange + 1) + minRange;
        int c = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("a equals:" + a);
        System.out.println("b equals:" + b);
        System.out.println("c equals:" + c);

        if (a > b && a > c) {
            System.out.println("The largest variable is: a");
        } else if (b > a && b > c) {
            System.out.println("The largest variable is: b");
        } else if (c > a && c > b) {
            System.out.println("The largest variable is: c");
        } else
            System.out.println("All variables have the same value");

    }
}
