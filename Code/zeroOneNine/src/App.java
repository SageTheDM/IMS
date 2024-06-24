import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number between 0 and 9 (or -1 to exit): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 0:
                    System.out.println("Your number is Zero");
                    break;
                case 1:
                    System.out.println("Your number is One");
                    break;
                case 2:
                    System.out.println("Your number is Two");
                    break;
                case 3:
                    System.out.println("Your number is Three");
                    break;
                case 4:
                    System.out.println("Your number is Four");
                    break;
                case 5:
                    System.out.println("Your number is Five");
                    break;
                case 6:
                    System.out.println("Your number is Six");
                    break;
                case 7:
                    System.out.println("Your number is Seven");
                    break;
                case 8:
                    System.out.println("Your number is Eight");
                    break;
                case 9:
                    System.out.println("Your number is Nine");
                    break;
                case -1:
                    System.out.println("Program terminated.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Program terminated.");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
