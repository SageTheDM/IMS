import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        boolean loop = true;

        do {
            System.out.println("Give me a number (with a decimal point if you have to)");
            double numberOne = scan.nextDouble();
            System.out.println("Give me another number (with a decimal point if you have to)");
            double numberTwo = scan.nextDouble();

            System.out.println("1 multiply, 2 divide, 3 sum, 4 bigger number, 5 average, 6 all -1 cancel");
            int userInput = scan.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("multiplacation: " + multiplyInput(numberOne, numberTwo));
                    break;
                case 2:
                    System.out.println("division: " + divideInput(numberOne, numberTwo));
                    break;
                case 3:
                    System.out.println("addition: " + addInput(numberOne, numberTwo));
                    break;
                case 4:
                    if (numberOne == numberTwo) {
                        System.out.println("The numbers are equal");
                        break;
                    } else
                        System.out.println("bigger number: " + biggerNumber(numberOne, numberTwo));
                    break;
                case 5:
                    System.out.println("average: " + averageNumber(numberOne, numberTwo));
                case 6:
                    System.out.println("multiplacation: " + multiplyInput(numberOne, numberTwo));
                    System.out.println("division: " + divideInput(numberOne, numberTwo));
                    System.out.println("addition: " + addInput(numberOne, numberTwo));
                    if (numberOne == numberTwo) {
                        System.out.println("The numbers are equal");
                        break;
                    } else
                        System.out.println("bigger number: " + addInput(numberOne, numberTwo));
                    System.out.println("sum: " + addInput(numberOne, numberTwo));
                case -1:
                    loop = false;
                    break;
                default:
                    System.out.println(userInput + " is not a valid input");
                    break;
            }
        } while (loop);

    }

    public static double divideInput(double numberOne, double numberTwo) {
        if (numberTwo == 0 || numberTwo == -0) {
            System.out.println("Error division by 0");
            return 0;
        } else {
            return numberOne / numberTwo;
        }
    }

    public static double multiplyInput(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    public static double addInput(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    public static double biggerNumber(double numberOne, double numberTwo) {
        if (numberOne > numberTwo) {
            return numberOne;
        } else {
            return numberTwo;
        }
    }

    public static double averageNumber(double numberOne, double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    // public static double digitSum(double numberOne, double numberTwo) {

    // }
}
