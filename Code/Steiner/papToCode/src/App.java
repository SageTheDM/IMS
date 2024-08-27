import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("What's thou name?");
        String name = scan.nextLine();
        System.out.println("On what year did you enter this hell hole");
        int year = scan.nextInt();
        System.out.println("How old are thou?");
        double age = scan.nextInt();

        double controllAge = 2023 - year;

        if (age == controllAge) {
            System.out.println("Dear " + name + " your math is on point");
        } else if (controllAge > age) {
            System.out.println("either you didn't have your birthday this year or you made a mistake");
        } else {
            System.out.println(
                    "If you're the doctor or any other form of time traveller everything is allright otherwise wtf?");
        }

        System.out.println("Do you want to buy alcohol (1 = yes 2 = no)");

    }
}
