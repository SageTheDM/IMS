
/*
 * Bis 8:00 Morgen --> morning
 * Bis 12:00 Vormittag --> late noon
 * bis 15:59 Nachmittag --> afternoon
 * 16:00 Zvieri --> "Zvieri"
 * bis 21:00 Abend --> Evening
 * bis 00:00 Nacht --> Night
 */

import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(
                "What time is it (you can use any DECIMAL number but use \",\" for decimal numbers please my terminal is acting funky idk why frfr)");
        double localTime = scan.nextDouble();

        if (localTime < (double) 0) {
            System.out.println("I don't think that's true");
        } else if (localTime > (double) 24) {
            System.out.println("Where do you live, my guy?");
        } else if (localTime == (double) 16) {
            System.out.println("It's Zvieri");
        } else if (localTime <= (double) 8) {
            System.out.println("It's morning");
        } else if (localTime <= (double) 12) {
            System.out.println("It's late morning");
        } else if (localTime <= (double) 15) {
            System.out.println("It's noon");
        } else if (localTime <= (double) 21) {
            System.out.println("It's evening");
        } else {
            System.out.println("It's night");
        }
    }
}
