public class Kuckuck extends Vogel {

    @Override
    public void singen() {
        System.out.println("Kuckuck geräusche");
    }

    @Override
    public void essen() {
        System.out.println("Der Kuckuck fliegt");
    }

    @Override
    public void bewegen() {
        System.out.println("Der Kuckuck frisst mücken - MAHLZEIT");
    }
}
