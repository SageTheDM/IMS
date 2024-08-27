import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int summe = 0;

        for (int x = 1; x < 3; x++) {
            for (int y = x; y > 1; y--) {
                summe += y;
            }
        }

        System.out.println(summe);
    }
}
