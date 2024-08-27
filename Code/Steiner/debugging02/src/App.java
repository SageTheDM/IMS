import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] varZahl = new int[10];

        //Erfassen der Daten
        while (true) {
            System.out.println("Bitte eine Zahl zwischen 0 und 9 (99 zum beenden)");
            int gluecksZahl = scan.nextInt();
            if (gluecksZahl < 0 || gluecksZahl > 9) {
                break;
            }
            varZahl[gluecksZahl]++;
        }

        //Ausgabe der Statistik
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + " :" + varZahl[i]);
        }

        //Ausgabe der maximal gewählten Zahl
        System.out.println("Meistgewählte Glückszahl: " + meistGewaehlteGlueckszahl(varZahl));

        scan.close();
    }

    /*
     * meistGewaehlteGlueckszahl
     */
    public static int meistGewaehlteGlueckszahl(int[] gluecksZahlen) {
        int meistGewaehlteZahl = -1;
        int anzahlMax = Integer.MIN_VALUE;
        for (int i = 0; i < gluecksZahlen.length; i++) {
            if (anzahlMax < gluecksZahlen[i]) {
                anzahlMax = gluecksZahlen[i];
                meistGewaehlteZahl = i;
            }
        }

        return meistGewaehlteZahl;
    }
}