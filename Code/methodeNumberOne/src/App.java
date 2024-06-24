import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Which char (if you feel funky even multiple) do you want to demonstrate the number?");
        String diagram = scan.nextLine();

        System.out.println("Text please");
        String textOne = scan.nextLine();
        System.out.println("Text please");
        String textTwo = scan.nextLine();
        System.out.println("Give me a number");
        int numberOne = scan.nextInt();
        System.out.println("Give me a number");
        int numberTwo = scan.nextInt();

        printText(textOne, numberOne, diagram);
        printText(textTwo, numberTwo, diagram);

        int numericSum = calcSum(numberOne, numberTwo);
        System.out.println("Numeric Sum: " + numericSum);

        charSum(diagram, numericSum);
    }

    public static void printText(String text, int zahl, String diagram) {
        System.out.println(text);
        printChar(zahl, diagram);
        System.out.println();
    }

    public static void printChar(int zahl, String diagram) {
        for (int i = 0; i < zahl; i++) {
            System.out.print(diagram);
        }
        System.out.println();
    }

    public static int calcSum(int summandA, int summandB) {
        return summandA + summandB;
    }

    public static void charSum(String diagram, int numericSum) {
        // Print the specified character the same number of times as the numeric sum
        for (int i = 0; i < numericSum; i++) {
            System.out.print(diagram);
        }
        System.out.println();
    }
}
