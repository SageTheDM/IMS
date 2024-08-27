public class App {
    public static void main(String[] args) throws Exception {
        int stunden = 0;
        int minuten = 0;
        int sekunden = 0;

        while (true) {
            sekunden += 30;

            if (sekunden == 60) {
                minuten++;
                sekunden = 0;
            }

            if (minuten == 60) {
                stunden++;
                minuten = 0;
            }

            if (stunden == 24) {
                break;
            }

            System.out.printf("%02d:%02d:%02d ", stunden, minuten, sekunden);
        }
    }
}
