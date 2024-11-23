public class App {
    public static void main(String[] args) throws Exception {
        // Aufgabe 1
        System.out.println("Aufgabe 1: \n");

        Konto konto1 = new Konto("0000000001", 1000);
        System.out.println(konto1.toString());
        konto1.einzahlen(500);
        konto1.abheben(750);
        System.out.println("\nDaten nach transaktionen: ");
        System.out.println(konto1.toString());

        // Aufgabe 2
        System.out.println("Aufgabe 2");
    }
}
