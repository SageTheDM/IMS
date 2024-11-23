public class Konto {
    private String kontonummer;
    private double kontostand;

    public Konto(String kontonummer, int kontostand) {
        if (kontonummer.length() == 10) {
            this.kontonummer = kontonummer;
            this.kontostand = kontostand;
        } else
            System.out.println("Es ist fehler beim erstellen des Konto aufgetreten");
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void abheben(double betrag) {
        if (kontostand >= 0) {
            this.kontostand -= betrag;
        } else
            System.out.println("Fehlermeldung #1225");
    }

    public void einzahlen(double betrag) {
        if (kontostand >= 0) {
            this.kontostand += betrag;
        } else
            System.out.println("Fehlermeldung #5221");
    }

    @Override
    public String toString() {
        return "Konto [Kontonummer=" + kontonummer + ", Kontostand=" + kontostand + "CHF]";
    }

}
