import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int myNumber = 12;
        System.out.println("Please type a number to add:");
        int numberToAdd = scan.nextInt();

        myNumber += numberToAdd;

        System.out.println(myNumber);

        scan.close();
    }
}
