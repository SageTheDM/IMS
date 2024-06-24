import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Deine Sprache/Your language (de/en)");
        String deineSprache = scan.next();
        int arbeitstagNummer = 0;

        switch (deineSprache) {
            case "en":
            case "En":
            case "eN":
            case "EN":
                System.out.println("Workday number (1=Monday, 2=Tuesday, 3=Wednesday, 4=Thursday, 5=Friday)");
                arbeitstagNummer = scan.nextInt();
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
                break;
            case "de":
            case "De":
            case "dE":
            case "DE":
                System.out.println("Arbeitstag-Nummer (1=Montag, 2=Dienstag, 3=Mittwoch, 4=Donnerstag, 5=Freitag)");
                arbeitstagNummer = scan.nextInt();
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
                break;
            default:
                System.out.println("Error");
                System.out.println("Sprache nicht erkannt");
                System.out.println("unfamiliar language");
                break;
        }
        scan.close();
    }
}