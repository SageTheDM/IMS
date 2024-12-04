// Luca Fbaian Burger
// Aufgabe 5

public abstract class Plugin {
    protected String name;
    protected String version;

    public Plugin(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void installieren() {
        System.out.println(this.name + " Version " + version + " wird installiert.");
    }

    public void deinstallieren() {
        // Logik
    }

    public abstract void ausfuehren();

}
