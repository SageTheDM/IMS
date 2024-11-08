import java.util.ArrayList;

public class Dokumenttest {

    public static void main(String[] args) {
        // ArrayList für die Dokumente
        ArrayList<Dokument> dokumente = new ArrayList<>();

        // Erstellen und Hinzufügen von Dokumenten
        dokumente.add(createDokument(
                "pdf",
                "PDF-Dokument 1",
                "Dies ist das erste PDF-Dokument. Es enthält mehrere Sätze. Es dient als Beispiel."));
        dokumente.add(createDokument(
                "pdf",
                "PDF-Dokument 2",
                "Das zweite PDF-Dokument folgt nun. Es zeigt einen weiteren Text. Auch dieser hat mehrere Sätze!"));
        dokumente.add(createDokument(
                "doc",
                "DOC-Dokument 1",
                "Dies ist das erste DOC-Dokument. Es hat einen anderen Text. Auch dieses Dokument enthält mehrere Sätze."));
        dokumente.add(createDokument(
                "doc",
                "DOC-Dokument 2",
                "Das zweite DOC-Dokument enthält ebenfalls einen Text. Hier gibt es viele Details. Aber keine Fragezeichen."));
        dokumente.add(createDokument(
                "doc",
                "DOC-Dokument 3",
                "Das dritte DOC-Dokument enthält interessante Informationen. Es sind viele Punkte hier. Schauen wir uns den Text an."));
        dokumente.add(createDokument(
                "docx",
                "DOCX-Dokument 1",
                "Dies ist das erste DOCX-Dokument. Der Text ist etwas anders. Wir haben jetzt neue Formatierungen!"));
        dokumente.add(createDokument(
                "docx",
                "DOCX-Dokument 2",
                "Das zweite DOCX-Dokument zeigt die neue Funktionalität. Es gibt keine großen Überraschungen. Doch die Struktur ist interessant."));

        // Ausgabe der Informationen der Dokumente
        printAllDocumentsInfo(dokumente);

        // Ausgabe der PDF-Dokumente
        printSpecificDocuments(dokumente, "pdf");

        // Berechnung und Ausgabe der Zeichen und Sätze in DOC- und DOCX-Dokumenten
        printTotalCharactersAndSentences(dokumente, "doc");
        printTotalCharactersAndSentences(dokumente, "docx");
    }

    // Methode zum Erstellen und Zurückgeben eines neuen Dokuments
    private static Dokument createDokument(String format, String titel, String text) {
        Dokument dokument = new Dokument(format);
        dokument.setTitel(titel);
        dokument.setText(text);
        return dokument;
    }

    // Ausgabe der Informationen aller Dokumente
    private static void printAllDocumentsInfo(ArrayList<Dokument> dokumente) {
        System.out.println("=== Ausgabe der Aller Dokumente ===");
        for (Dokument doc : dokumente) {
            doc.zeigeInfo();
            System.out.println("Anzahl Zeichen: " + doc.anzahlZeichen());
            System.out.println("Anzahl Sätze: " + doc.anzahlSaetze());
            System.out.println();
        }
    }

    // Ausgabe von Dokumenten eines bestimmten Formats
    private static void printSpecificDocuments(ArrayList<Dokument> dokumente, String format) {
        System.out.println("=== Ausgabe der " + format.toUpperCase() + "-Dokumente ===");
        for (Dokument doc : dokumente) {
            if (doc.getDateiFormat().equalsIgnoreCase(format)) {
                System.out.println(doc.getTitel());
                System.out.println(doc.getText());
                System.out.println("=================================================");
            }
        }
    }

    private static void printTotalCharactersAndSentences(ArrayList<Dokument> dokumente, String format) {
        int gesamtZeichen = 0;
        int gesamtSaetze = 0;
        for (Dokument doc : dokumente) {
            if (doc.getDateiFormat().equalsIgnoreCase(format)) {
                gesamtZeichen += doc.anzahlZeichen();
            }
            gesamtSaetze += doc.anzahlSaetze();
        }

        // Ausgabe der Gesamtzeichen und -sätze
        System.out.println("\n=== Gesamtzahl der Zeichen in " + format.toUpperCase() + "-Dokumenten ===");
        System.out.println("Gesamtzeichen: " + gesamtZeichen);
        System.out.println("\n=== Gesamtzahl der Sätze in ALLEN-Dokumenten ===");
        System.out.println("Gesamtzahl Sätze: " + gesamtSaetze);
    }
}
