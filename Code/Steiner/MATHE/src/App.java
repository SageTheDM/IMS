// Alle Brechnungen mit der Annahme Juni und schönes Wetter
public class App {
    public static void main(String[] args) throws Exception {

        // Grösse der Fahrzeuge
        double pkw = 2.2;
        // Lastwagen und Büsse
        double lastwagen = 10;
        double mottorad = 1.8;

        // Wahrscheinschlichkeit
        double waPkw = 70;
        double waLastwagen = 15;
        double waMottorad = 15;

        // Strecke
        double laenge = 6000;
        double spuren = 2;

        // brechnungen

        // Strecke
        double strecke = laenge * spuren;

        // durchscnittliche länge
        // plus 6 2m abstand für 3 fahrzeuge
        double anzahl = (pkw * waPkw + lastwagen * waLastwagen + mottorad * waMottorad + 6) / 100;

        // durschnittliche länge
        System.err.println(anzahl);

        // verrechnung
        int fahrzeuge = (int) (strecke / anzahl);
        System.out.println("Die durchsnittliche anzahl Fahrzeuge für eine Staustrecke von " + laenge + "beträgt: "
                + fahrzeuge);
    }
}
