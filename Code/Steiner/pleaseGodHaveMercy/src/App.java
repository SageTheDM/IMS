public class App {

    public static void main(String[] args) {
        calcFaculty(1, 15);
        System.out.println();

        calcFibonacci(20);
        System.out.println();
        System.out.println();

        calcSquareNumber(7, 34);

    }

    public static void calcFaculty(int low, int high) {
        for (int i = low; i <= high; i++) {
            int factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }
            if (i < 10) {
                System.out.println("Fakultät von 0" + i + " ist: " + factorial);
            } else
                System.out.println("Fakultät von " + i + " ist: " + factorial);
        }

    }

    public static void calcFibonacci(int bound) {
        int a = 0, b = 1, c;
        System.out.println("Fibonacci-Reihe bis zum " + bound + ". Glied:");
        for (int i = 1; i <= bound; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }

    }

    public static void calcSquareNumber(int low, int bound) {
        System.out.println("Quadratzahlen von " + low + " bis " + bound + ":");
        for (int i = low; i <= bound; i++) {
            if (i < 10) {
                System.out.println("0" + i + " zum Quadrat ist: " + (i * i));
            } else
                System.out.println(i + " zum Quadrat ist: " + (i * i));
        }
    }
}