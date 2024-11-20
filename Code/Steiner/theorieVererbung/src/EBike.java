public class EBike extends Fahrrad {
    private int leistungInWatt;

    public EBike(String marke, int artikelnummer, double preis, int leistungInWatt) {
        super(marke, artikelnummer, preis);
        this.leistungInWatt = leistungInWatt;
    }

    public int getLeistungInWatt() {
        return leistungInWatt;
    }

    public void setLeistungInWatt(int leistungInWatt) {
        this.leistungInWatt = leistungInWatt;
    }

    // Methoden
    public void ausgabeInfoAufKonsole() {
        System.out.println("#" + getArtikelnummer() + " " + getMarke() + " - Preis: " + getPreis() + " - Motor: "
                + leistungInWatt);

    }

}