import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Define the variable x, if you would be so kind:");
        int x = scan.nextInt();
        System.out.println("now again for y, please:");
        int y = scan.nextInt();

        System.out.println("Before the exchange");
        System.out.println(x);
        System.out.println(y);

        // Exchange
        int z = x;
        x = y;
        y = z;

        System.out.println("after the exchange");
        System.out.println(x);
        System.out.println(y);

        /*
         * Tauschen Sie die Inhalte der beiden Variablen! D. h.: Wenn vor dem
         * Tausch x den Wert 5 hatte und y den Wert 7, dann soll x nach dem
         * Tausch den Wert 7 haben und y den Wert 5. Führen Sie den Tausch
         * so durch, dass der Tausch funktioniert, egal mit welchen Werten x
         * und y initialisiert wurden.
         * Sie dürfen nur Code zwischen den beiden Kommentaren //Tausch
         * und //Nach dem Tausch hinzufügen!
         */

        scan.close();
    }
}