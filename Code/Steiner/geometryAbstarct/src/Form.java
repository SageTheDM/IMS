
public abstract class Form {
    protected String farbe;
    protected Position position;

    public Form(String farbe, int x, int y) {
        this.farbe = farbe;
        Position tempPosition = new Position(x, y);
        this.position = tempPosition;
    }

    public Position getPosition() {
        return position;
    }

    protected abstract void zeichnen();
}
