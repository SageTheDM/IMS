// Luca Fabian Burger
// Aufgabe 2
public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    Datum(int tag, int monat, int jahr) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setMonat(int monat) {
        if (monat <= 12 && monat >= 0)
            this.monat = monat;
        else
            this.monat = 1;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    // Aufgabe a
    int getDifferent(Datum datum) {
        // Logic
        return 12;
    }

    // Aufgabe b
    String getWochentag() {
        // Logic
        return "Montag";
    }

    // Aufgabe C
    void addTage(int anzahlTage) {
        this.tag += anzahlTage;
    }

    // Aufgabe d
    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    // Aufgabe e
    String getDatumNummerisch() {
        String rueckgabe = "";
        rueckgabe += this.tag + ". ";
        rueckgabe += this.monat + ". ";
        rueckgabe += this.jahr;
        return rueckgabe;
    }

    // Aufgabe f
    String getDatumMonat() {
        String rueckgabe = "";
        String monatString = "";
        switch (this.monat) {
            case 1:
                monatString = "Januar";
                break;
            case 2:
                monatString = "Februar";
                break;
            case 3:
                monatString = "März";
                break;
            case 4:
                monatString = "April";
                break;
            case 5:
                monatString = "Mai";
                break;
            case 6:
                monatString = "Juni";
                break;
            case 7:
                monatString = "Juli";
                break;
            case 8:
                monatString = "August";
                break;
            case 9:
                monatString = "September";
                break;
            case 10:
                monatString = "Oktober";
                break;
            case 11:
                monatString = "November";
                break;
            case 12:
                monatString = "Dezember";
                break;
            default:
                monatString = "Januar";
                break;
        }
        rueckgabe += this.tag + ". ";
        rueckgabe += monatString + " ";
        rueckgabe += this.jahr;
        return rueckgabe;
    }

}
