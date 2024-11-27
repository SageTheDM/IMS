public class Konto {
    private String kontonummer;
    private double kontostand;

    // Constructor
    public Konto(String kontonummer, double kontostand) {
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
    }

    // Getter for kontostand
    public double getKontostand() {
        return kontostand;
    }

    // Getter for kontonummer
    public String getKontonummer() {
        return kontonummer;
    }

    // Method to deposit money
    public void einzahlen(double betrag) {
        kontostand += betrag;
    }

    // Method to withdraw money
    public void auszahlen(double betrag) {
        if (kontostand >= betrag) {
            kontostand -= betrag;
        } else {
            System.out.println("Fehler: Nicht genügend Geld auf dem Konto!");
        }
    }

    @Override
    public String toString() {
        return "Konto [Kontonummer=" + kontonummer + ", Kontostand=" + kontostand + "]";
    }
}
