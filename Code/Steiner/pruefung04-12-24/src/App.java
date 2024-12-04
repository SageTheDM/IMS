// Luca Fbaian Burger
// Aufgabe 4

public class App {
    public static void main(String[] args) throws Exception {
        DatenanalysePlugin data = new DatenanalysePlugin("DataAnalyzer", "1.0", "Kundendaten");
        UIPlugin ui = new UIPlugin("FancyUI", "1.1", "Buttons and slider");

        data.installieren();
        data.hinzufuegenDatenquelle("Einkausdaten");
        data.ausfuehren();
        ui.installieren();
        ui.ausfuehren();
        ui.anpassen("Graphen und Digramme");
        ui.ausfuehren();
    }
}
