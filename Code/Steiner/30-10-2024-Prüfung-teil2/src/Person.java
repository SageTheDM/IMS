// Luca Fabian Burger
// Aufgabe 3
public class Person {
    private String name;
    private boolean geschlecht;

    Person(String name, boolean geschlecht) {
        this.name = name;
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(boolean geschlecht) {
        this.geschlecht = geschlecht;
    }

}
