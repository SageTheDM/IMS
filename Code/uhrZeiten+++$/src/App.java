public class App {
    public static void main(String[] args) throws Exception {

        for (int stunden = 0; stunden < 24; stunden++) {
            for (int minuten = 0; minuten < 60; minuten += 15) {

                System.out.printf("%02d:%02d ", stunden, minuten);

            }
        }
    }
}
