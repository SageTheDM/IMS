import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Arbeitstag-Nummer (1=Montag, 2=Dienstag, 3=Mittwoch, 4=Donnerstag, 5=Freitag)");
        int arbeitstagNummer = scan.nextInt();
        scan.close();
        String tag = "leer";

        switch (arbeitstagNummer) {
            case 1:
                tag = "Montag";
                break;
            case 2:
                tag = "Dienstag";
                break;
            case 3:
                tag = "Mittwoch";
                break;
            case 4:
                tag = "Donnerstag";
                break;
            case 5:
                tag = "Freitag";
                break;

            default:
                System.out.println("error");
        }

        // Checking for errors
        if (tag.equals("leer")) {
            System.out.println("please don't do that again");
        } else {
            System.out.println(tag);
        }
    }
}