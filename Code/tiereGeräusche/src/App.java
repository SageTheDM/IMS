// Luca Burger
// Aufgabe 3

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("gib den namen eines Tieres ein");
        String tier = scan.nextLine();

        if (tier.equalsIgnoreCase("Hund")) {
            System.out.println("wuuuf");
        } else if (tier.equalsIgnoreCase("Kuh") || tier.equalsIgnoreCase("Stier")) {
            System.out.println("muuuuuuuuuh");
        } else if (tier.equalsIgnoreCase("Katze")) {
            System.out.println("miauuuuuuuu");
        } else {
            System.out.println("unbekanntes Tier");
        }
        scan.close();
    }
}