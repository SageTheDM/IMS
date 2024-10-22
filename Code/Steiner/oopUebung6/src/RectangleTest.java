import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for length and width
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();

        // Create a Rectangle object
        Rectangle rectangle = new Rectangle(length, width);

        System.out.println("What do you want to do? (1: increase, 2: decrease)");
        int input = scanner.nextInt();

        if (input == 1) {
            // Increase the dimension
            System.out.println("Which dimension do you want to increase? (1: width, 2: length)");
            input = scanner.nextInt();
            if (input == 1) {
                // Increase width
                System.out.print("Increase width by: ");
                double increaseBy = scanner.nextDouble();
                rectangle.increaseWidth(increaseBy);
            } else if (input == 2) {
                // Increase length
                System.out.print("Increase length by: ");
                double increaseBy = scanner.nextDouble();
                rectangle.increaseLength(increaseBy);
            } else {
                System.out.println("Invalid input for dimension choice.");
            }
        } else if (input == 2) {
            // Decrease the dimension
            System.out.println("Which dimension do you want to decrease? (1: width, 2: length)");
            input = scanner.nextInt();
            if (input == 1) {
                // Decrease width
                System.out.print("Decrease width by: ");
                double decreaseBy = scanner.nextDouble();
                rectangle.decreaseWidth(decreaseBy);
            } else if (input == 2) {
                // Decrease length
                System.out.print("Decrease length by: ");
                double decreaseBy = scanner.nextDouble();
                rectangle.decreaseLength(decreaseBy);
            } else {
                System.out.println("Invalid input for dimension choice.");
            }
        } else {
            System.out.println("Invalid input for action choice.");
        }

        // Display the results
        System.out.println("Longer side: " + rectangle.getLongerSide());
        System.out.println("Shorter side: " + rectangle.getShorterSide());
        System.out.println("Diagonal: " + rectangle.getDiagonal());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        scanner.close();
    }
}
