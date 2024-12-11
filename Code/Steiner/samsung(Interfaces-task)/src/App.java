import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Samsung> devices = new ArrayList<Samsung>();
        devices.add(new GalaxyJ3(11.85, "Phone"));
        devices.add(new GalaxyS5(12.45, "phone", "sunset-black"));

        for (Samsung samsung : devices) {
            System.out.println(samsung.preis);
            System.out.println(samsung.produktTyp);
            if (samsung instanceof GalaxyS5) {
                System.out.println(((GalaxyS5) samsung).farbe);
            }
            System.out.println("Funktionstest");
            if (samsung instanceof ITelefon) {
                ((ITelefon) samsung).powerOn();
                ((ITelefon) samsung).esKlingelt();
                ((ITelefon) samsung).anrufen();
            }
            System.out.println();
        }
    }
}
