// Luca Burger
// AUFGABE 1

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // Nutzer Eingabe
        System.out.println("Einen Tag bitte (als Zahl)");
        int tag = scan.nextInt();
        System.out.println("Einen Monat bitte (als Zahl)");
        int monat = scan.nextInt();
        System.out.println("Ein jahr (für vor Christi negative verwenden)");
        int jahr = scan.nextInt();
        System.out.println("1. Januar " + jahr + " = 0, Montag .... 6, Sonntag");
        int startTag = scan.nextInt();

        int tagImJahr = 0;
        if (tag > 0 && tag <= 31) {
            switch (monat) {
                case 1:
                    tagImJahr = tag;
                    break;
                case 2:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 31;
                    break;
                case 3:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 59;
                    break;
                case 4:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 90;
                    break;
                case 5:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 120;
                    break;
                case 6:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 150;
                    break;
                case 7:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 181;
                    break;
                case 8:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 212;
                    break;
                case 9:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 242;
                    break;
                case 10:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 273;
                    break;
                case 11:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 303;
                    break;
                case 12:
                    tagImJahr = tag;
                    tagImJahr = tagImJahr + 334;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        } else {
            System.out.println("error");
        }

        if (jahr % 4 == 0 && (jahr % 100 != 0 || jahr % 400 == 0)) {
            tagImJahr++;
        }
        System.out.println("Datum: " + tag + "." + monat + "." + jahr);
        System.out.println(tagImJahr + ". Tag im Jahr");

        // Berechnung welcher Wochentag
        double woche = tagImJahr / 7;
        System.out.println("Kalenderwoche: " + (int) woche);
        int wochentag = (int) woche / startTag;
        wochentag = -1; // Berechnung hat nicht Funktioniert :(

        switch (wochentag) {
            case 0:
                System.out.println("Montag");
                break;
            case 1:
                System.out.println("Dienstag");
                break;
            case 2:
                System.out.println("Mittwoch");
                break;
            case 3:
                System.out.println("Donnerstag");
                break;
            case 4:
                System.out.println("Freitag");
                break;
            case 5:
                System.out.println("Samstag");
                break;
            case 6:
                System.out.println("Sonntag");
                break;
            default:
                System.out.println("Wochentag konnte nicht berechnet werden");
                break;
        }
    }
}
