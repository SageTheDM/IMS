public class App {
    public static void main(String[] args) throws Exception {
        // Testing Values
        double black[] = { 0.0, 0.0, 0.0 };
        double grey[] = { 0.5, 0.5, 0.5 };
        double white[] = { 1, 1, 1 };

        procentTo255(black);
        procentTo255(grey);
        procentTo255(white);

        final int BLACK = oneInteger(black);
        final int GREY = oneInteger(grey);
        final int WHITE = oneInteger(white);

        printAll(BLACK, GREY, WHITE);
    }

    public static void procentTo255(double[] color) {
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            if (color[i] == 1.0) {
                temp = 255;
            } else {
                temp = (int) (color[i] * 256);
            }
            color[i] = temp;
        }
    }

    public static int oneInteger(double[] color) {
        int temp = 0;
        temp += color[0] * (256 * 256);
        temp += color[1] * (256);
        temp += color[2];
        return temp;
    }

    public static void printAll(int black, int grey, int white) {
        System.out.println("Black: " + black);
        System.out.println("Grey: " + grey);
        System.out.println("White: " + white);
    }
}
