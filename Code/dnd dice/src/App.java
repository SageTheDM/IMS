import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int numberOfRolls = 1000;
        int numberOfDice = 4;

        int[] results = new int[numberOfRolls];

        // Simulate rolling 4d6 and dropping the lowest value for 1000 times
        for (int i = 0; i < numberOfRolls; i++) {
            results[i] = rollAndDropLowest(numberOfDice);
        }

        // Sort the results for calculating median
        Arrays.sort(results);

        // Calculate and print lowest, highest, average, and median values
        int lowest = results[0];
        int highest = results[numberOfRolls - 1];
        double average = Arrays.stream(results).average().orElse(0);

        int median;
        if (numberOfRolls % 2 == 0) {
            median = (results[numberOfRolls / 2 - 1] + results[numberOfRolls / 2]) / 2;
        } else {
            median = results[numberOfRolls / 2];
        }

        System.out.println("Lowest: " + lowest);
        System.out.println("Highest: " + highest);
        System.out.println("Average: " + average);
        System.out.println("Median: " + median);
    }

    // Simulate rolling n dice and dropping the lowest value
    private static int rollAndDropLowest(int n) {
        int[] rolls = new int[n];

        // Roll the dice
        for (int i = 0; i < n; i++) {
            rolls[i] = (int) (Math.random() * 6) + 1;
        }

        // Sort the rolls and drop the lowest value
        Arrays.sort(rolls);
        int sum = rolls[1] + rolls[2] + rolls[3];

        return sum;
    }
}
