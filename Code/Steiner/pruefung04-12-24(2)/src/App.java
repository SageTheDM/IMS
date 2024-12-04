//Luca Fbian Burger
// Aufgabe 5

public class App {
    public static void main(String[] args) throws Exception {
        // Erstelle ein beschriftetes Rechteck
        LabeledRectangle rect = new LabeledRectangle(10, 20, 100, 50, "Mein Rechteck");

        // Informationen übder das Rechteck asugeben
        System.out.println("Rechteck-Informationen");
        System.out.println(rect.getInfo());

        // Grenzen des Rechtecks verschieben und ändern
        System.out.println("\nÄndere die Grenzen des Rechtecks...");
        rect.setBounds(50, 60, 200, 100);

        // Prüfen ob ein Punkt innerhalb des Rechtecks liegt
        int testX = 130;
        int testY = 140;
        System.out.println("\nPrüfe ob Punkt (" + testX + ", " + testY + ") im Rechteck liegt:");
        if (rect.contains(testX, testY)) {
            System.out.println("Der Punkt liegt im Rechteck.");
        } else {
            System.out.println("Der Punkt liegt ausserhalb des Rechtecks.");
        }
    }
}
