import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // variables for score
        double question = 0;
        final double QuestionTotal = 6;
        double grade = 1;

        // Anwsers
        System.out.println("is Sargans in Graubünden? y/n");
        String anwserOne = scan.nextLine();
        System.out.println("Is Lichtenstein bigger than St. Gallen? y/n");
        String anwserTwo = scan.nextLine();
        System.out.println("is Bielefeld real? y/n");
        String anwserThree = scan.nextLine();
        System.out.println("Is St. Moritz in Switzerland y/n");
        String anwserFor = scan.nextLine();
        System.out.println("Has Lichtenstein a own army y/n");
        String anwserFive = scan.nextLine();
        System.out.println("Is the Matterhorn a mountain y/n");
        String anwserSix = scan.nextLine();

        // correction
        if (anwserOne.equalsIgnoreCase("n")) {
            question++;
        }
        if (anwserTwo.equalsIgnoreCase("n")) {
            question++;
        }
        if (anwserThree.equalsIgnoreCase("n")) {
            question++;
        }
        if (anwserFor.equalsIgnoreCase("y")) {
            question++;
        }
        if (anwserFive.equalsIgnoreCase("n")) {
            question++;
        }
        if (anwserSix.equalsIgnoreCase("y")) {
            question++;
        }

        // Score
        grade = question / QuestionTotal * 5 + 1;

        /*
         * // Rounding
         * if (grade >= 1 && grade < 1.5) {
         * grade = 1;
         * } else if (grade >= 1.5 && grade < 2.5) {
         * grade = 2;
         * } else if (grade >= 2.5 && grade < 3.5) {
         * grade = 3;
         * } else if (grade >= 3.5 && grade < 4.5) {
         * grade = 4;
         * } else if (grade >= 4.5 && grade < 5) {
         * grade = 5;
         * }
         */

        // text feedback
        switch ((int) grade) {
            case 1:
                System.out.println("Ouh tuff buddy");
                break;
            case 2:
                System.out.println("Please learn more");
                break;
            case 3:
                System.out.println("So close buddy");
                break;
            case 4:
                System.out.println("Good job Buddy");
                break;
            case 5:
                double distantToPerfection = (double) 6 - grade;
                System.out.println("Absolut Mastermind only " + distantToPerfection + " short to perfection");
                break;
            case 6:
                System.out.println("Mastermind");
                break;
            default:
                System.out.println("Error");
                break;
        }

        System.out.println("In other words your grade is: " + grade);
        scan.close();

    }
}
