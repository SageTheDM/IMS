import java.util.Random;
import java.util.Scanner;

public class test {
    // Spielfeld-Zeichen
    public static final int LEER = 0; // ' '
    public static final int WASSER = 1; // 'O'
    public static final int SCHIFF = 2; // 'X'
    public static final int VERSENKT = 3; // 'S'
    public static final int VERSTECKT = 4; // ' '
    public static final int ENTHÜLLT = 5; // 'R'

    // spielfeld[vertikal --> y][horizontal --> x]
    public static int[][] spielfeld = new int[10][10];

    // Array, in dem die Schiffe gespeichert sind
    private static int[] schiffX = new int[10];
    private static int[] schiffY = new int[10];
    private static boolean[] schiffRichtung = new boolean[10];
    private static int[] schiffLänge = new int[10];

    // Anzahl der abgefeuerten Schüsse
    public static int abgefeuerteSchüsse = 0;
    public static boolean spielLäuft = true;

    public static void main(String[] args) {
        boolean sindSchiffeEnthüllt = false;
        // Regeln erklären
        spielInitialisieren();
        do {
            spielfeldZeigen();
            System.out.println(
                    "Wohin möchtest du schießen? (z.B., A5 oder ? für einen Tipp oder -1 zum Beenden des Spiels)");
            String eingabe = koordinateEingeben();

            switch (eingabe) {
                case "-1":
                    spielLäuft = false;
                    break;
                case "?":
                    versteckteSchiffeZeigen();
                    sindSchiffeEnthüllt = true;
                    break;
                default:
                    // Die Zeilen 47-49 sollten beim Debuggen deaktiviert werden, um es einfacher zu
                    // machen
                    if (sindSchiffeEnthüllt) {
                        enthüllteSchiffeVerstecken();
                    }
                    schussVerarbeiten(eingabe);
                    break;
            }
        } while (spielLäuft);
    }

    // Verarbeitet die Schusseingabe des Spielers, validiert sie und führt den
    // Schuss aus.
    private static void schussVerarbeiten(String eingabe) {
        try {
            char xChar = eingabe.toLowerCase().charAt(0);
            int y = Integer.parseInt(eingabe.substring(1)) - 1;
            int x = xChar - 'a';
            if (eingabeIstGültig(x, y)) {
                String ergebnis = schießen(x, y);
                System.out.println(ergebnis);
                System.out.println("Anzahl der abgefeuerten Schüsse: " + abgefeuerteSchüsse);
                if (alleSchiffeVersenkt()) {
                    spielfeldZeigen();
                    System.out.println("Alle Schiffe wurden versenkt\nDu hast das Spiel gewonnen\n");
                    spielfeldZeigen();
                    spielLäuft = false;
                }
            } else {
                System.out.println("Ungültige Eingabe. Bitte gib eine gültige Koordinate ein (z.B., A5).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ungültiges Eingabeformat. Bitte gib eine gültige Koordinate ein (z.B., A5).");
        }
    }

    // Zeigt die Positionen der versteckten Schiffe auf dem Spielfeld an.
    private static void versteckteSchiffeZeigen() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (spielfeld[i][j] == VERSTECKT) {
                    spielfeld[i][j] = ENTHÜLLT;
                }
            }
        }
    }

    // Versteckt die zuvor enthüllten Schiffe auf dem Spielfeld.
    private static void enthüllteSchiffeVerstecken() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (spielfeld[i][j] == ENTHÜLLT) {
                    spielfeld[i][j] = VERSTECKT;
                }
            }
        }
    }

    // Initialisiert das Spiel, indem das Spielfeld eingerichtet und Schiffe
    // zufällig platziert werden.
    private static void spielInitialisieren() {
        // Spielfeld mit leeren Feldern füllen
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = LEER;
            }
        }

        // Schiffe zufällig platzieren
        Random zufall = new Random();
        int i = 0;
        int[] schiffe = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };
        for (int schiffGröße : schiffe) {
            boolean platziert = false;
            while (!platziert) {
                int x = zufall.nextInt(10);
                int y = zufall.nextInt(10);
                boolean richtung = zufall.nextBoolean();
                if (platzierungIstGültig(x, y, schiffGröße, richtung)) {
                    schiffLänge[i] = schiffGröße;
                    schiffX[i] = x;
                    schiffY[i] = y;
                    schiffRichtung[i] = richtung;

                    i++;
                    schiffPlatzieren(x, y, schiffGröße, richtung);
                    platziert = true;
                }
            }
        }
    }

    // Validiert die Platzierung eines Schiffs auf dem Spielfeld.
    private static boolean platzierungIstGültig(int x, int y, int schiffGröße, boolean richtung) {
        if (!innerhalbGrenzen(x, y, schiffGröße, richtung)) {
            return false;
        }

        if (überschneidung(x, y, schiffGröße, richtung)) {
            return false;
        }

        return hatWasserPlatz(x, y, schiffGröße, richtung);
    }

    // Überprüft, ob die Schiffplatzierung innerhalb der Spielfeldgrenzen liegt.
    private static boolean innerhalbGrenzen(int x, int y, int schiffGröße, boolean richtung) {
        if (richtung) {
            return x >= 0 && x + schiffGröße <= 10 && y >= 0 && y < 10;
        } else {
            return y >= 0 && y + schiffGröße <= 10 && x >= 0 && x < 10;
        }
    }

    // Überprüft, ob sich die Schiffplatzierung mit vorhandenen Schiffen
    // überschneidet.
    private static boolean überschneidung(int x, int y, int schiffGröße, boolean richtung) {
        for (int i = 0; i < schiffGröße; i++) {
            int reihe = richtung ? y : y + i;
            int spalte = richtung ? x + i : x;

            if (spielfeld[reihe][spalte] != LEER) {
                return true; // Überschneidet sich mit einem vorhandenen Schiff
            }
        }
        return false;
    }

    // Stellt sicher, dass das Schiff einen Platz mit Wasser um sich herum hat.
    private static boolean hatWasserPlatz(int x, int y, int schiffGröße, boolean richtung) {
        for (int i = 0; i < schiffGröße; i++) {
            int reihe = richtung ? y : y + i;
            int spalte = richtung ? x + i : x;

            for (int j = reihe - 1; j <= reihe + 1; j++) {
                for (int k = spalte - 1; k <= spalte + 1; k++) {
                    if (j >= 0 && j < 10 && k >= 0 && k < 10 && spielfeld[j][k] != LEER) {
                        return false; // Benachbartes Feld ist kein Wasser
                    }
                }
            }
        }
        return true; // Hat Platz mit Wasser
    }

    // Platziert ein Schiff auf dem Spielfeld an den angegebenen Koordinaten.
    private static void schiffPlatzieren(int x, int y, int schiffGröße, boolean richtung) {
        if (richtung) {
            for (int i = 0; i < schiffGröße; i++) {
                spielfeld[y][x + i] = VERSTECKT;
            }
        } else {
            for (int i = 0; i < schiffGröße; i++) {
                spielfeld[y + i][x] = VERSTECKT;
            }
        }
    }

    // Holt die Koordinateneingabe vom Benutzer.
    private static String koordinateEingeben() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    // Überprüft, ob die Eingabekoordinaten gültig sind.
    private static boolean eingabeIstGültig(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    // Verarbeitet einen Schuss auf die angegebenen Koordinaten und gibt das
    // Ergebnis zurück.
    private static String schießen(int x, int y) {
        switch (spielfeld[y][x]) {
            case LEER:
                spielfeld[y][x] = WASSER;
                abgefeuerteSchüsse++;
                return "Daneben!";
            case WASSER:
                return "Dieses Feld wurde bereits beschossen!";
            case VERSTECKT:
            case ENTHÜLLT:
                spielfeld[y][x] = SCHIFF;
                abgefeuerteSchüsse++;
                if (schiffVersenkt(x, y)) {
                    schiffVersenken(x, y);
                    return "Du hast ein Schiff versenkt!";
                } else {
                    return "Du hast ein Schiff getroffen!";
                }
            default:
                return "Ungültiger Zustand!";
        }
    }

    // Versenkt ein Schiff, indem alle seine Teile als versenkt markiert werden.
    private static void schiffVersenken(int x, int y) {
        for (int i = 0; i < schiffX.length; i++) {
            int startX = schiffX[i];
            int startY = schiffY[i];
            int länge = schiffLänge[i];
            boolean richtung = schiffRichtung[i]; // true für horizontal, false für vertikal

            // Überprüfen, ob der aktuelle Schuss Teil dieses Schiffes ist
            if (richtung) {
                // Horizontales Schiff
                if (y == startY && x >= startX && x < startX + länge) {
                    // Markiere alle Teile des Schiffes als versenkt
                    for (int j = 0; j < länge; j++) {
                        spielfeld[startY][startX + j] = VERSENKT;
                    }

                    for (int j = 0; j < länge; j++) {
                        wasserUmSchiffPlatzieren(startX + j, startY);
                    }
                    return;
                }
            } else {
                // Vertikales Schiff
                if (x == startX && y >= startY && y < startY + länge) {
                    // Markiere alle Teile des Schiffes als versenkt
                    for (int j = 0; j < länge; j++) {
                        spielfeld[startY + j][startX] = VERSENKT;
                    }

                    for (int j = 0; j < länge; j++) {
                        wasserUmSchiffPlatzieren(startX, startY + j);
                    }
                    return;
                }
            }
        }
    }

    // Überprüft, ob ein Schiff an den angegebenen Koordinaten vollständig versenkt
    // ist.
    private static boolean schiffVersenkt(int x, int y) {
        for (int i = 0; i < schiffX.length; i++) {
            int startX = schiffX[i];
            int startY = schiffY[i];
            int länge = schiffLänge[i];
            boolean richtung = schiffRichtung[i]; // true für horizontal, false für vertikal

            // Überprüfen, ob der aktuelle Schuss Teil dieses Schiffes ist
            if (richtung) {
                // Horizontales Schiff
                if (y == startY && x >= startX && x < startX + länge) {
                    // Überprüfen alle Teile des Schiffes
                    for (int j = 0; j < länge; j++) {
                        if (spielfeld[startY][startX + j] != SCHIFF && spielfeld[startY][startX + j] != VERSENKT) {
                            return false; // Wenn ein Teil nicht getroffen ist, ist das Schiff nicht versenkt
                        }
                    }
                    return true; // Alle Teile sind getroffen, das Schiff ist versenkt
                }
            } else {
                // Vertikales Schiff
                if (x == startX && y >= startY && y < startY + länge) {
                    // Überprüfen alle Teile des Schiffes
                    for (int j = 0; j < länge; j++) {
                        if (spielfeld[startY + j][startX] != SCHIFF && spielfeld[startY + j][startX] != VERSENKT) {
                            return false; // Wenn ein Teil nicht getroffen ist, ist das Schiff nicht versenkt
                        }
                    }
                    return true; // Alle Teile sind getroffen, das Schiff ist versenkt
                }
            }
        }
        return false; // Wenn der Schuss kein Teil eines Schiffes ist (sollte in einem gültigen Spiel
                      // nicht passieren)
    }

    // Zeigt den aktuellen Zustand des Spielfelds auf der Konsole an.
    private static void spielfeldZeigen() {
        System.out.println("   | A | B | C | D | E | F | G | H | I | J |");
        System.out.println("--------------------------------------------");
        char[] symbole = { ' ', 'O', 'X', 'S', ' ', 'R' };

        for (int i = 0; i < spielfeld.length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + " |");
            } else {
                System.out.print(" " + (i + 1) + "|");
            }
            for (int j = 0; j < spielfeld[i].length; j++) {
                System.out.print(" " + symbole[spielfeld[i][j]] + " |");
            }
            System.out.println("\n--------------------------------------------");
        }
    }

    // Platziert Wasser um ein versenktes Schiff, um dessen Umgebung zu markieren.
    private static void wasserUmSchiffPlatzieren(int x, int y) {
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10 && spielfeld[i][j] == LEER) {
                    spielfeld[i][j] = WASSER;
                }
            }
        }
    }

    // Überprüft, ob alle Schiffe auf dem Spielfeld versenkt sind.
    private static boolean alleSchiffeVersenkt() {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (spielfeld[i][j] == VERSTECKT || spielfeld[i][j] == ENTHÜLLT) {
                    return false; // Ein Schiff wurde gefunden, das nicht versenkt ist
                }
            }
        }
        return true; // Alle Schiffe sind versenkt
    }
}
