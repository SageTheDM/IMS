public class App {

    public static void main(String[] args) {
        calcMathI(5, 1);
        calcMathI(10, 2);
        calcMathII(3, 5, 1);
        calcMathII(7, 10, 1);

    }

    public static void calcMathI(int startValue, int step) {

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += startValue + (i * step);
        }
        System.out.println("Summe mit Startwert " + startValue + " und Schrittweite " + step + ": " + sum);

    }

    public static void calcMathII(int startValue, int endValue, int product) {
        for (int i = startValue; i <= endValue; i++) {
            product *= i;
        }
        System.out.println("Produkt von " + startValue + " bis " + endValue + ": " + product);
    }

}