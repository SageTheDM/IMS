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
            anzahlDurchgaenge += 1;
        }

        // Datentypen
        byte myByte = 127;
        short myShort = 300;

        // With float the f is necassary because java otherwise treats it as a double
        // (simplified anwser)
        double myDoubleValue = 34.568956;
        float myFloatValue = 17.567f;

        // Constant always uppercase // Fixed Number

        final double PI = 3.141592876;

        int xx = 0;
        long yy = 2;
        xx++; // inkrement
        xx--; // dekrement

        xx += (int) y; // Making y (long) a int for calculation
        xx += 1; // Short for x = x +1
        yy += 4; // Short for y = y +4
        yy %= 3; // short for y = y%3 %=Modulo (Ganzahliges Geteiltdurch)

        // Square root
        double d1 = Math.sqrt(10);

        System.out.println(d1 + "noch etwas schreiben" + d1);

    }
}