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

            System.out.println("1 multiply, 2 divide, -1 cancel");
            int userInput = scan.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println(multiplyInput(numberOne, numberTwo));
                    break;
                case 2:
                    System.out.println(divideInput(numberOne, numberTwo));
                    break;
                case -1:
                    loop = false;
                    break;
                default:
                    System.out.println(userInput + " is not a valid input");
                    break;
            }

            if (loop) {
                System.out.println("Want to try others numbers? 1 yes 2 no");
                int continueInput = scan.nextInt();

                switch (continueInput) {
                    case 1:
                        System.out.println("==========================");
                        break;
                    case 2:
                        loop = false;
                        break;
                    case -1:
                        System.out.println("why would you enter that? EXTERMINATE");
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid Input stopped code");
                        loop = false;
                        break;
                }
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

}
