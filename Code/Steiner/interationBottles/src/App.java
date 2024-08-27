import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        {
            int emptyBottle = 0;
            System.out.println("Give me the volume of an empty bottle (in ml)");
            int maxVolume = scan.nextInt();
            System.out.println("Give me the volume for all the full bottles (in ml)");
            int fullBottle = scan.nextInt();
            int numberOfRuns = 0;

            while (emptyBottle < maxVolume) {
                numberOfRuns++;
                System.out.println(numberOfRuns + " run");
                emptyBottle += fullBottle;
            }
            System.out.println("it takes " + numberOfRuns + " bottles to fill the empty one");
            System.out.println("end of code");

        }
    }
}
