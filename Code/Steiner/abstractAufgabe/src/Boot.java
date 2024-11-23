// Klasse Boot
public class Boot extends Fahrzeug {
    public Boot(String name) {
        super(name);
    }

    @Override
    public void bewegen() {
        System.out.println("Das Boot " + getName() + " fährt auf dem Wasser.");
    }
}