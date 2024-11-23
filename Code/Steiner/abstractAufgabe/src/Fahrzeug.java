// Basisklasse Fahrzeug
public abstract class Fahrzeug {
    private String name;

    public Fahrzeug(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void bewegen();
}
