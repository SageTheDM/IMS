public class App {

    public static void main(String[] args) {
        // Aufgabe 1
        String meinText = "Ich bin ein völlig zufälliger und neutraler Text.";
        System.out.println(textLeft(meinText, 3)); // Konsolenausgabe: Ich

        // Aufgabe 2
        System.out.println(textRight(meinText, 5)); // Konsolenausgabe: Text.

        // Aufgabe 3
        String buchstaben = "9";
        int positionImAbc = zeichenPositionImAbc(buchstaben) + 1;
        if (positionImAbc == 0) {
            System.out.println(buchstaben + " is not in the alphabet");
        } else
            System.out.println(buchstaben + " ist der " + positionImAbc + ". Buchstaben im Abc");
    }

    // Aufgabe 1
    public static String textLeft(String text, int anzahlZeichenVonLinks) {
        return text.substring(0, Math.min(anzahlZeichenVonLinks, text.length()));
    }

    // Aufgabe 2
    public static String textRight(String text, int anzahlZeichenVonRechts) {
        return text.substring(Math.max(text.length() - anzahlZeichenVonRechts, 0));
    }

    // Aufgabe 3
    public static int zeichenPositionImAbc(String zeichen) {
        if (zeichen.length() != 1) {
            return -1;
        } else {
            return Character.toUpperCase(zeichen.charAt(0)) - 'A';
        }
    }
}
