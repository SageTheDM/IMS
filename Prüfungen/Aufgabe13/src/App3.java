
// Luca Fabian Burger
// Aufgabe 15

import java.util.Scanner;

public class App3 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Erste Zahl");
        int zahl1 = scan.nextInt();
        System.out.println("Zweite Zahl");
        int zahl2 = scan.nextInt();
        System.out.println("Dritte Zahl");
        int zahl3 = scan.nextInt();
        System.out.println("Vierte Zahl");
        int zahl4 = scan.nextInt();
        System.out.println("Orginal: " + zahl1 + " " + zahl2 + " " + zahl3 + " " + zahl4);

        // Ab hier programmieren
        int behaelter = 0;

        behaelter = zahl1;
        zahl1 = zahl4;
        zahl4 = behaelter;
        behaelter = zahl2;
        zahl2 = zahl3;
        zahl3 = behaelter;

        // Bis hierhin programmieren
        System.out.println("Umgekehrt: " + zahl1 + " " + zahl2 + " " + zahl3 + " " + zahl4);
    }
}