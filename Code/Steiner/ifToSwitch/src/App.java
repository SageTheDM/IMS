import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Deine Sprache/Your language (de/en)");
        String deineSprache = scan.next();
        int arbeitstagNummer = 0;

        if (deineSprache.equals("de")) {
            System.out.println("Arbeitstag-Nummer (1=Montag, 2=Dienstag, 3=Mittwoch, 4=Donnerstag, 5=Freitag)");
            arbeitstagNummer = scan.nextInt();
        } else if (deineSprache.equals("en")) {
            System.out.println("Workday number (1=Monday, 2=Tuesday, 3=Wednesday, 4=Thursday, 5=Friday)");
            arbeitstagNummer = scan.nextInt();
        } else {
            System.out.println("Error");
        }
        scan.close();

        if (deineSprache.equalsIgnoreCase("de")) {
            switch (arbeitstagNummer) {
                case 1:
                    System.out.println("Montag");
                    break;
                case 2:
                    System.out.println("Dienstag");
                    break;
                case 3:
                    System.out.println("Mittwoch");
                    break;
                case 4:
                    System.out.println("Donnerstag");
                    break;
                case 5:
                    System.out.println("Freitag");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else if (deineSprache.equalsIgnoreCase("en")) {

            switch (arbeitstagNummer) {
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("Sprache nicht erkannt");
            System.out.println("unfamiliar language");
        }

        // Code von der Herr Steiner
        /*
         * if (deineSprache.equalsIgnoreCase("de")) {
         * if (arbeitstagNummer == 1)
         * System.out.println("Montag");
         * else if (arbeitstagNummer == 2)
         * System.out.println("Dienstag");
         * else if (arbeitstagNummer == 3)
         * System.out.println("Mittwoch");
         * else if (arbeitstagNummer == 4)
         * System.out.println("Donnerstag");
         * else if (arbeitstagNummer == 5)
         * System.out.println("Freitag");
         * else
         * System.out.println("Das ist kein Arbeitstag.");
         * } else if (deineSprache.equalsIgnoreCase("en")) {
         * if (arbeitstagNummer == 1)
         * System.out.println("Monday");
         * else if (arbeitstagNummer == 2)
         * System.out.println("Tuesday");
         * else if (arbeitstagNummer == 3)
         * System.out.println("Wednesday");
         * else if (arbeitstagNummer == 4)
         * System.out.println("Thursday");
         * else if (arbeitstagNummer == 5)
         * System.out.println("Friday");
         * else
         * System.out.println("This is not a working day.");
         * } else {
         * System.out.println("Diese Sprache kenne ich nicht: " + deineSprache);
         * }
         */

    }
}
