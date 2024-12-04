// Luca Fbaian Burger
// Aufgabe 5

public class UIPlugin extends Plugin {
    private String uiElement;

    public UIPlugin(String name, String version, String uiElement) {
        super(name, version);
        this.uiElement = uiElement;
    }

    public void ausfuehren() {
        System.out.println("UI Erweiterung wird ausgeführt: " + this.uiElement);
    }

    public void anpassen(String uiElement) {
        this.uiElement = uiElement;
        System.out.println("UI angepasst zu: " + this.uiElement);
    }
}
