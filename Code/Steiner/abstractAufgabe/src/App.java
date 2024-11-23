// Hauptprogramm App
public class App {
    public static void main(String[] args) {
        Auto auto = new Auto("Ferrari");
        Boot boot = new Boot("Titanic");

        auto.bewegen();
        boot.bewegen();
    }
}
