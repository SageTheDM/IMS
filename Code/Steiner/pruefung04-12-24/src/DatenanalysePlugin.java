// Luca Fbaian Burger
// Aufgabe 5

import java.util.ArrayList;

public class DatenanalysePlugin extends Plugin {
    private ArrayList<String> datenquellen = new ArrayList<String>();

    public DatenanalysePlugin(String name, String version, String datenquelle) {
        super(name, version);
        datenquellen.add(datenquelle);
    }

    public void ausfuehren() {
        for (String string : datenquellen) {
            System.out.println("Datenanalyse für " + string + " wird durchgeführt.");
        }
    }

    public void hinzufuegenDatenquelle(String neueDatenquelle) {
        datenquellen.add(neueDatenquelle);
        System.out.println("Datenquelle hinzugefügt: " + neueDatenquelle);
    }
}
