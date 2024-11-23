public class Rechteck extends Form {
    private int hoehe;
    private int breite;

    public Rechteck(String farbe, int x, int y, int hoehe, int breite) {
        super(farbe, x, y);
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public void aendereGroesse(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public void zeichnen() {
        System.out.println("Zeichne ein Rechteck an der Position (" + getPosition().getX() + ", " + getPosition().getY()
                + ") mit der Breite " + breite + " und der Höhe " + hoehe);
    }
}
