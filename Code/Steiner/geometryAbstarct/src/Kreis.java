public class Kreis extends Form {
    private int radius;

    public Kreis(String farbe, int x, int y, int radius) {
        super(farbe, x, y);
        this.radius = radius;
    }

    public void aendereRadius(int myInt) {
        this.radius += myInt;
    }

    @Override
    public void zeichnen() {
        System.out.println("Zeichne Kreis an der Position (" + getPosition().getX() + ", " + getPosition().getY()
                + ") mit dem radius " + radius);
    }
}
