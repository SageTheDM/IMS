// Luca Fabian Burger
// Aufgabe 3
public class App {
    public static void main(String[] args) throws Exception {
        // Zimmer erstellen
        Zimmer[] zimmers = new Zimmer[3];
        zimmers[0] = new Zimmer(1, 6); // Zimmer 1, 6 Personen Kapazität
        zimmers[1] = new Zimmer(2, 2);
        zimmers[2] = new Zimmer(3, 10);
        // Einige Personen zu Zimmer hinzufügen
        zimmers[0].hinzufuegenPerson(new Person("Fritz", false)); // Name, Geschlecht
        zimmers[1].hinzufuegenPerson(new Person("Anna", true));
        zimmers[1].hinzufuegenPerson(new Person("Lena", true));
        // Informationen ausgeben
        for (Zimmer zimmer : zimmers) {
            System.out.println(
                    "Personen im Zimmer " + zimmer.getNummer() + " (Belegung " + zimmer.belegung() + "):");
            zimmer.printPersonenListe();
        }
    }
}
