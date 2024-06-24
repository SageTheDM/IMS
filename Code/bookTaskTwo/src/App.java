import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a postive number");
        int number = scan.nextInt();
        int numberDigits = 0;

        for (int digits = 0; number > 0; digits++) {
            number = number / 10;
            numberDigits++;
        }
        System.out.println("Your number contains: " + numberDigits + " digit(s).");
    }
}
