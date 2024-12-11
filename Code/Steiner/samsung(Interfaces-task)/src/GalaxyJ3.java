public class GalaxyJ3 extends Samsung implements ITelefon {

    public GalaxyJ3(double preis, String produktTyp) {
        super(preis, produktTyp);
    }

    @Override
    public void powerOn() {
        System.out.println("GalaxyJ3 is starting");
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
