import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] namen = { "Gian", "Leotrim", "Kevin", "Marco" };

        print(namen);
        swapArrayPosi(namen, 0, 4);
        swapArrayPosi(namen, 1, 2);

        System.out.println("Print after the switch:");
        System.out.println("-----------------");

        print(namen);
    }

    public static void swapArrayPosi(String[] namen, int numberOne, int numberTwo) {
        if (numberOne < 0 || numberOne >= namen.length || numberTwo < 0 || numberTwo >= namen.length) {
            System.out.println("Error: Invalid indices for array swap.");
        } else {
            String placeholderString = namen[numberOne];
            namen[numberOne] = namen[numberTwo];
            namen[numberTwo] = placeholderString;
        }
    }

    public static void print(String[] namen) {
        for (int i = 0; i < namen.length; i++) {
            System.out.println(namen[i]);
        }
    }

}
