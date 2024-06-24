// Luca Fabian Burger
// Aufgabe 3

public class App {
    public static void main(String[] args) throws Exception {
        int[] sitzPlaetze = new int[100];
        sitzPlaetze[1] = 45;
        sitzPlaetze[17] = 12;
        sitzPlaetze[32] = 25;
        sitzPlaetze[45] = 54;
        sitzPlaetze[85] = 88;

        double durchscnittalter = getAvarageAge(sitzPlaetze);
        int[] belegteSitze = getBelegteSitze(sitzPlaetze);
        int youngestAge = getYoungestAge(sitzPlaetze, belegteSitze);
        printOut("Das durchscnittliche Alter ist : ", durchscnittalter);
        printOut("Das jüngste Alter ist : ", youngestAge);

    }

    public static int[] getBelegteSitze(int[] sitzPlaetze) {
        int controllNumber = 0;
        int[] belegteSitze = new int[sitzPlaetze.length];
        for (int i = 0; i < sitzPlaetze.length; i++) {
            if (sitzPlaetze[i] > 0) {
                belegteSitze[controllNumber] = i;
                controllNumber++;
            }
        }
        return belegteSitze;
    }

    public static double getAvarageAge(int[] sitzPlaetze) {
        double avarageAge = 0;
        int anzahlBesucher = 0;

        for (int i = 0; i < sitzPlaetze.length; i++) {
            if (sitzPlaetze[i] > 0) {
                avarageAge += sitzPlaetze[i];
                anzahlBesucher++;
            }
        }
        return avarageAge / anzahlBesucher;
    }

    public static int getYoungestAge(int[] sitzPlaetze, int[] belegteSitze) {
        int youngestAge = 100000;
        for (int i = 0; i < belegteSitze.length; i++) {
            for (int o = 0; o < belegteSitze.length; o++) {
                if (sitzPlaetze[i] < youngestAge && sitzPlaetze[i] != 0) {
                    youngestAge = sitzPlaetze[i];
                }
            }
        }
        return youngestAge;

    }

    public static void printOut(String myText, double myValue) {
        System.out.println(myText + myValue);
    }
}