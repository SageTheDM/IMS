// Luca Burger
// Aufgabe 2

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Wie schwer ist die Sendung (in g)");
        int gewicht = scan.nextInt();
        boolean individuelleBriefmarke = false;

        if (gewicht <= 50 && gewicht > 0) {
            System.out.println("Soll die Sendung versichert werden?");
            if (versichert.equalsIgnoreCase("j")) {
                System.out.println("Standartbrief versichert");
            } else {
                System.out.println("Standartbrief unversichert");
            }
        } else if (gewicht > 50 && gewicht <= 100) {
            System.out.println("Soll die Sendung versichert werden?");
            String versichert2 = scan.nextLine();
            if (versichert2.equalsIgnoreCase("j")) {
                System.out.println("Kompaktbrief versichert");
            } else {
                System.out.println("Kopaktbrief unversichert");
            }
            System.out.println("Möchten Sie eine Individuelle Briefmarke?");
            String frage = scan.nextLine();
            if (frage.equalsIgnoreCase("j")) {
                individuelleBriefmarke = true;
            }
        } else if (gewicht <= 500) {
            System.out.println("Grossbrief");
        } else {
            System.out.println("Sendung weiterleiten an Paketstation");
        }
        System.out.println("BESTEN Dank für die Sendungsaufgabe wir wünschen Ihnen...");
    }
}
