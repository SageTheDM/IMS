public class Fahrrad {
    private String marke;
    private int artikelnummer;
    private double preis;

    public Fahrrad(String marke, int artikelnummer, double preis) {
        this.marke = marke;
        this.artikelnummer = artikelnummer;
        this.preis = preis;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void ausgabeInfoAufKonsole() {
        System.out.println("#" + artikelnummer + " " + marke + " - Preis: " + preis);
    }

    public void umgebungGenissen() {
        System.out.println("Ich geniesse es, mit dem " + marke + " durch die atomar verseuchte Landschaft zu fahren");
    }
}