public class Dokument {
    private String titel;
    private String text;
    private String dateiFormat;

    // Konstruktor mit Validierung des Dateiformats
    public Dokument(String dateiFormat) {
        // Default-Werte für Titel und Text
        this.titel = "";
        this.text = "";

        // Validierung des Dateiformats
        if (dateiFormat.equalsIgnoreCase("pdf") || dateiFormat.equalsIgnoreCase("doc")
                || dateiFormat.equalsIgnoreCase("docx")) {
            this.dateiFormat = dateiFormat.toLowerCase();
        } else {
            this.dateiFormat = "pdf"; // Default-Wert im Fehlerfall
        }
    }

    // Getter für den Titel
    public String getTitel() {
        return titel;
    }

    // Setter für den Titel
    public void setTitel(String titel) {
        this.titel = titel;
    }

    // Getter für den Text
    public String getText() {
        return text;
    }

    // Setter für den Text
    public void setText(String text) {
        this.text = text;
    }

    // Getter für das Dateiformat
    public String getDateiFormat() {
        return dateiFormat;
    }

    // Methode, die Infos zum Dokument ausgibt
    public void zeigeInfo() {
        System.out.println("Titel: " + titel);
        System.out.println("Text: " + text);
        System.out.println("Dateiformat: " + dateiFormat);
    }

    // Methode zur Berechnung der Anzahl Zeichen im Text
    public int anzahlZeichen() {
        return text.length();
    }

    // Methode zur Berechnung der Anzahl Sätze im Text
    public int anzahlSaetze() {
        int anzahl = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == ':' || c == '?' || c == '!') {
                anzahl++;
            }
        }
        return anzahl;
    }
}
