import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int minNumber = 0;
        int maxNumber = 20;
        int cancel = -1;

        System.out.println("Which char (if you feel funky even multiple) do you want to demonstrate the number?");
        String diagram = scan.nextLine();

        do {

            System.out.println("Please enter a number from " + minNumber + " to " + maxNumber + " (enter " + cancel
                    + " to cancel)");
            int userInput = scan.nextInt();

            if (userInput == cancel) {
                System.out.println("Program canceled");
                break;
            }

            if (userInput > maxNumber || userInput < minNumber) {
                System.out.println("Invalid Input, self destruction activated");
                break;
            }

            for (int i = 0; i < userInput; i++) {
                System.out.print(diagram);
            }
            System.out.println("");

        } while (true);

        System.out.println("Program ended");
        scan.close();

    }
}
