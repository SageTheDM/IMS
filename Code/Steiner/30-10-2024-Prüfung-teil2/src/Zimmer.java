// Luca Fabian Burger
// Aufgabe 3
public class Zimmer {
    private int zimmernummer;
    private int kapazitaet;
    // Problem nicht hinbekommen dynamisch
    private Person[] personen = new Person[10];
    private int belegungZimmer = 0;

    Zimmer(int zimmerNummer, int kapazitaet) {
        this.zimmernummer = zimmerNummer;
        this.kapazitaet = kapazitaet;
    }

    void hinzufuegenPerson(Person person) {
        if (belegungZimmer < personen.length) {
            if (belegungZimmer != 0) {
                if (personen[belegungZimmer--] != personen[belegungZimmer]) {
                    this.personen[belegungZimmer] = person;
                    belegungZimmer++;
                } else {
                    System.out.println("Error mehr als ein geschlecht im Raum");
                }
            } else {
                this.personen[belegungZimmer] = person;
                belegungZimmer++;
            }
        } else {
            System.out.println("Zimmer ausgebucht");
        }
    }

    int getNummer() {
        return this.zimmernummer;
    }

    String belegung() {
        return belegungZimmer + "/" + kapazitaet;
    }

    // funktioniert nicht
    String printPersonenListe() {
        String personenListe = "";
        for (int i = 0; i < this.belegungZimmer; i++) {
            personenListe += "- ";
            personenListe += personen[i].getName();
            boolean temp = personen[i].isGeschlecht();
            if (temp)
                personenListe += ": " + "männlich";
            else
                personenListe += ": " + "weiblich";
            personenListe += "\n";
        }
        return personenListe;
    }
}
