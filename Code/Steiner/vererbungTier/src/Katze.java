// Subklasse Katze
public class Katze extends Tier {
    public Katze(String name) {
        super(name);
    }

    @Override
    public void gibLaut() {
        System.out.println(name + " macht miau");
    }
}