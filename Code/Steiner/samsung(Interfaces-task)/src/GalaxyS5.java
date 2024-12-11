public class GalaxyS5 extends Samsung implements ITelefon {
    String farbe;

    public GalaxyS5(double preis, String produktTyp, String farbe) {
        super(preis, produktTyp);
        this.farbe = farbe;
    }

    @Override
    public void powerOn() {
        System.out.println("GalaxyJ5 is starting");
    }

    @Override
    public void esKlingelt() {
        System.out.println("DING DING DING");
    }

    @Override
    public void anrufen() {
        System.out.println("No one will pick up - since you have no signal in the basement");
    }
}
