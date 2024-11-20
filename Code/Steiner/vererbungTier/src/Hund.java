
// Subklasse Hund
public class Hund extends Tier {
    public Hund(String name) {
        super(name);
    }

    @Override
    public void gibLaut() {
        System.out.println(name + " macht Wau");
    }
}