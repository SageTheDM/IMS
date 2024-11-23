// Superklasse Tier
public abstract class Tier {
    protected String name;

    public Tier(String name) {
        this.name = name;
    }

    public abstract void gibLaut();

    public void schlafen() {
        System.out.println(name + " schläft");
    }
}
