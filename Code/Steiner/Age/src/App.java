import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double ageParent = 0;
        double ageChild = 0;

        ageParent = getInput("Parent");
        ageChild = getInput("Child");

        System.out.println("Calculating when the child is half the age of the parent");

        for (double x = 0; x >= 0; x++) {
            if ((ageParent + x) / 2 == ageChild + x) {
                ageChild += x;
                ageParent += x;
                System.out.println("age of the child: " + ageChild);
                System.out.println("age of the parent: " + ageParent);
                System.out.println("That will be in " + x + " years");
                break;
            }
        }
    }

    public static int getInput(String x) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the age of " + x + ": ");
        return scan.nextInt();
    }
}
