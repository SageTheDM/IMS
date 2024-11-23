public class App {
    public static void main(String[] args) throws Exception {
        Fahrrad meinfahrrad = new Fahrrad("Scott", 1, 8500);
        meinfahrrad.ausgabeInfoAufKonsole();

        EBike meinEbike = new EBike("Thömus", 2, 12500, 250);
        meinEbike.ausgabeInfoAufKonsole();

        meinfahrrad.umgebungGenissen();
        meinEbike.umgebungGenissen();
    }
}