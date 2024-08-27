
// împort java extansions
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Give me a number please:");
        int number = scan.nextInt();
        int math = 0;
        int numberOfDigits = 0;
        int sum = 0;

        // Number of digits
        for (int tempNumber = number; tempNumber > 0; tempNumber = tempNumber / 10) {
            numberOfDigits++;
        }

        // math the digits-diffrence
        for (int tempNumber = number; tempNumber > 0; tempNumber = tempNumber / 10) {
            math = tempNumber % 10;
            sum += math;
        }

        System.out.println("Anzahl der Ziffern: " + numberOfDigits);
        System.out.println("Ziffernsumme: " + sum);

        scan.close();
    }
}
