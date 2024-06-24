// Luca Fabian Burger
// Aufgabe 13
// Die Eingabe von Fliesskomazahlen funktioniert nicht

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Was ist dein Vorname?");
        String vorname = scan.next();

        System.out.println("Wie schwer sind Sie in KG? (mit Kommastellen)");
        double gewicht = scan.nextDouble();

        System.out.println("Wie gross sind Sie in Meter (mit Kommastellen)");
        double groesse = scan.nextDouble();

        double bmi = gewicht / (groesse * groesse);

        System.out.println("Lieber " + vorname + " dein BMI beträgt: " + bmi);

        scan.close();
    }
}
