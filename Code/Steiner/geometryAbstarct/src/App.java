public class App {
    public static void main(String[] args) throws Exception {
        Kreis myKreis = new Kreis("blau", 10, 5, 1);
        Rechteck myRechteck = new Rechteck("gelb", 0, -12, 2, 5);

        System.out.println("Werte vor der modifizierung");
        zeichne(myKreis, myRechteck);

        System.out.println("modifikationen");
        myKreis.position.bewegen(12, -11);
        myRechteck.position.bewegen(33, 12);
        myKreis.aendereRadius(3);
        myRechteck.aendereGroesse(23, 12);

        System.out.println("Werte nach der Veränderung");
        zeichne(myKreis, myRechteck);

    }

    private static void zeichne(Kreis myKreis, Rechteck myRechteck) {
        myKreis.zeichnen();
        myRechteck.zeichnen();
    }
}
