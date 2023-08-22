import javax.swing.JOptionPane;

public class Gaptext {
    public static void main(String[] args) {
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
    }
}