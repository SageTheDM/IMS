public class App {
    public static void main(String[] args) {
        // Einige Tiere erstellen
        Tier loewe = new Tier("Löwe", "Leo");
        Tier elefant = new Tier("Elefant", "Dumbo");
        Tier pinguin = new Tier("Pinguin", "Pingu");

        // Gehege mit Kapazität von 5 Tieren erstellen
        Gehege gehege1 = new Gehege(1, 5);

        // Tiere zum Gehege hinzufügen
        gehege1.hinzufuegenTier(loewe);
        gehege1.hinzufuegenTier(elefant);
        gehege1.hinzufuegenTier(pinguin);

        // Informationen ausgeben
        System.out.println("Gehege Nummer: " + gehege1.getNummer());
        Tier[] tiereImGehege = gehege1.getTiere();
        for (Tier tier : tiereImGehege) {
            System.out.println("Tier: " + tier.getArt() + " - Name: " + tier.getName());
        }

        // Name eines Tieres ändern
        loewe.setName("Simba");

        // Überprüfen, ob der Name des Tieres aktualisiert wurde
        System.out.println("Aktualisierter Name des Löwen: " + loewe.getName());
    }
}
