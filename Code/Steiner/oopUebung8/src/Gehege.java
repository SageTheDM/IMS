public class Gehege {
    private int nummer;
    private Tier[] tierListe;
    private int aktuelleAnzahlTiere;
    private int kapazitaet;

    // Konstruktor, der die Nummer und die Kapazität des Geheges annimmt
    Gehege(int nummer, int kapazitaet) {
        this.nummer = nummer;
        this.kapazitaet = kapazitaet;
        this.tierListe = new Tier[kapazitaet];
        this.aktuelleAnzahlTiere = 0;
    }

    // Methode zum Hinzufügen eines Tieres
    public void hinzufuegenTier(Tier tier) {
        if (aktuelleAnzahlTiere < kapazitaet) {
            tierListe[aktuelleAnzahlTiere] = tier;
            aktuelleAnzahlTiere++;
            System.out.println("Tier hinzugefügt: " + tier.getName());
        } else {
            System.out.println("Das Gehege ist voll. Tier konnte nicht hinzugefügt werden.");
        }
    }

    // Methode zum Entfernen eines Tieres
    public void entfernenTier(Tier tier) {
        for (int i = 0; i < aktuelleAnzahlTiere; i++) {
            if (tierListe[i].equals(tier)) {
                // Tier entfernen und Array neu ordnen
                for (int j = i; j < aktuelleAnzahlTiere - 1; j++) {
                    tierListe[j] = tierListe[j + 1];
                }
                tierListe[aktuelleAnzahlTiere - 1] = null;
                aktuelleAnzahlTiere--;
                System.out.println("Tier entfernt: " + tier.getName());
                return;
            }
        }
        System.out.println("Tier nicht gefunden: " + tier.getName());
    }

    // Methode zum Zurückgeben der aktuellen Liste der Tiere
    public Tier[] getTiere() {
        Tier[] tiereImGehege = new Tier[aktuelleAnzahlTiere];
        System.arraycopy(tierListe, 0, tiereImGehege, 0, aktuelleAnzahlTiere);
        return tiereImGehege;
    }

    // Methode zum Zurückgeben der Nummer des Geheges
    public int getNummer() {
        return nummer;
    }
}
