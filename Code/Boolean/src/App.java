public class App {
    public static void main(String[] args) throws Exception {

        boolean a = 1 == 1;
        boolean b = 1 != 2;
        boolean c = a == b;
        boolean d = c != b;

        if (d) {
            System.out.println("d  is true see: " + d);
        } else {
            System.out.println("d is false see: " + d);
        }
    }
}
