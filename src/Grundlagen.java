import java.util.Random;

import javax.swing.JOptionPane;

public class Grundlagen {
    public static void main(String[] args) {
        // Hello World
        System.out.println("Hello World");

        // Zahlen Variablen
        int x = 99;
        int y = 2;
        x = x + 1;
        x = x + y;
        System.out.println(x);

        // Buchstaben Variablen
        char myA = 'a';
        System.out.println(myA);

        // If & else
        if (x > 101) {
            System.out.println("Der Wert ist grösser als 101");
        } else {
            System.out.println("Der Wert ist kleiner als 101");
        }

        // Iteration
        int anzahlDurchgaenge = 1;
        while (anzahlDurchgaenge <= 5) {
            System.out.println("Durchgang nr. " + anzahlDurchgaenge);
            anzahlDurchgaenge = anzahlDurchgaenge + 1;
        }

        // Lückentexte / kombination aus variablen, print und if/else

        // Popups mit User Input
        String a = JOptionPane.showInputDialog("Please enter a verb (-ing):");
        String b = JOptionPane.showInputDialog("Please enter a location:");
        String c = JOptionPane.showInputDialog("Please enter a color:");
        String d = JOptionPane.showInputDialog("Please enter something that's that color:");
        String e = JOptionPane.showInputDialog("Please enter a diffrent color:");
        String f = JOptionPane.showInputDialog("Please enter something that's that color:");
        String g = JOptionPane.showInputDialog("Please enter an adjective:");
        String h = JOptionPane.showInputDialog("Please enter an object");

        // Error message

        if (a == null || a.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (b == null || b.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (c == null || c.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (d == null || d.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (e == null || e.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (f == null || f.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (g == null || g.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else if (h == null || h.trim().isEmpty()) {
            System.out.println("Missing word(s) or canceled.");
        } else {

            // Lückentext mit variablen

            System.out.println("They where " + a + " throw (a) " + b + ". They're eyes where ");
            System.out.println(c + " as (the) " + d + " They're hair as " + e + " as (the) " + f + ".");
            System.out.println("It was a " + g + " day, after a long journey they finally found their " + h);
        }

        // Print text

        System.out.println("A code request you have made,");
        System.out.println("Fear not, for I am here to aid.");
        System.out.println("In Java, a language so grand,");
        System.out.println("I'll lend you a helping hand.");

        // Creating a Random object
        Random random = new Random();

        // Define the range for xx, yy and zz
        int minRange = -10000;
        int maxRange = 10000;

        // Generate random values for xx, zz and yy within the specified range
        int xx = random.nextInt(maxRange - minRange + 1) + minRange;
        int yy = random.nextInt(maxRange - minRange + 1) + minRange;
        int zz = random.nextInt(maxRange - minRange + 1) + minRange;

        int sum = xx + yy + zz;

        System.out.println("The sum of " + xx + ", " + yy + " and " + zz + " is: " + sum);

        System.out.println("May the code be with you!");
    }
}