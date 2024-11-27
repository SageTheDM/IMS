public class App {
    public static void main(String[] args) {
        // Aufgabe 1: Konto
        System.out.println("Aufgabe 1: Konto\n");

        // Create Konto object
        Konto konto = new Konto("0000000001", 1000.0);
        System.out.println("Initiales Konto:");
        System.out.println(konto);

        // Perform transactions
        konto.einzahlen(500.0);
        konto.auszahlen(750.5);

        // Print final state
        System.out.println("\nKonto nach Transaktionen:");
        System.out.println(konto);

        // Aufgabe 2: Girokonto
        System.out.println("\nAufgabe 2: Girokonto\n");

        // Create Girokonto object
        Girokonto gk = new Girokonto("0000000001", 10000.0, 1000.0);

        // Test withdrawals and deposits
        gk.auszahlen(11000.0); // Should succeed
        System.out.println("Kontostand: " + gk.getKontostand());

        gk.einzahlen(11000.0); // Deposit
        gk.auszahlen(11001.0); // Should fail (exceeds limit)
        System.out.println("Kontostand: " + gk.getKontostand());
    }
}
