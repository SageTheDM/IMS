public class Girokonto extends Konto {
    private double limit;

    // Constructor
    public Girokonto(String kontonummer, double kontostand, double limit) {
        super(kontonummer, kontostand);
        this.limit = limit;
    }

    // Getter for limit
    public double getLimit() {
        return limit;
    }

    // Setter for limit
    public void setLimit(double limit) {
        this.limit = limit;
    }

    // Overridden auszahlen method
    @Override
    public void auszahlen(double betrag) {
        if (getKontostand() - betrag >= -limit) {
            super.auszahlen(betrag);
        } else {
            System.out.println("Fehler: Kreditlimit überschritten!");
        }
    }
}
