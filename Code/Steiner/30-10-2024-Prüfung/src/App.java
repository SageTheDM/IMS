// Luca Fabian Burger
// Aufgabe 2
public class App {
    public static void main(String[] args) throws Exception {
        Datum datum1 = new Datum(1, 1, 2000);
        Datum datum2 = new Datum(1, 1, 2000);
        // Aufgabe a
        System.out.println(datum1.getDifferent(datum2));
        // Aufgabe b
        System.out.println(datum1.getWochentag());
        // Aufagbe c
        datum1.addTage(2);
        System.out.println(datum1.getTag());
        // Aufgabe d
        System.out.println(datum1.getTag() + " " + datum1.getMonat() + " " + datum1.getJahr());
        // Aufgabe e
        System.out.println(datum1.getDatumNummerisch());
        // Aufgabe f
        System.out.println(datum1.getDatumMonat());
    }
}