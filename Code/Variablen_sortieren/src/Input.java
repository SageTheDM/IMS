import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Zahl 1:");
        int numberOne = scan.nextInt();

        System.out.println("Zahl 2:");
        int numberTwo = scan.nextInt();

        System.out.println("Zahl 3:");
        int numberThree = scan.nextInt();

        System.out.println("a equals: " + numberOne);
        System.out.println("b equals: " + numberTwo);
        System.out.println("c equals: " + numberThree);

        /*
         * Deaktiviert da ich das logische Und noch nicht kennen darf
         * 
         * if (numberOne > numberTwo && numberOne > numberThree) {
         * System.out.println("The largest variable is: a");
         * } else if (numberTwo > numberOne && numberTwo > numberThree) {
         * System.out.println("The largest variable is: b");
         * } else if (numberThree > numberOne && numberThree > numberTwo) {
         * System.out.println("The largest variable is: c");
         * } else
         * System.out.println("All variables have the same value");
         */

        if (numberOne > numberTwo) {
            if (numberOne > numberThree) {
                System.out.println(numberOne + " (aka a) is the biggest");
            }
        } else if (numberTwo > numberThree) {
            System.out.println(numberTwo + " (aka b) is the biggest");
        } else if (numberThree != numberOne) {
            System.out.println(numberThree + " (aka c) is the biggest");
        } else {
            System.out.println("all variables are the same thing");
        }
    }
}