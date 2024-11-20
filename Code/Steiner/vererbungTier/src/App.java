
public class App {
    public static void main(String[] args) {
        Hund bello = new Hund("Bello");
        Katze felix = new Katze("Felix");

        bello.gibLaut();
        bello.schlafen();

        felix.gibLaut();
        felix.schlafen();
    }
}