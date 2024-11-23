
// Klasse Auto
public class Auto extends Fahrzeug {
    public Auto(String name) {
        super(name);
    }

    @Override
    public void bewegen() {
        System.out.println("Das Auto " + getName() + " fährt auf der Strasse.");
    }
}