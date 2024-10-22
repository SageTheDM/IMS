public class Tier {
    private String art;
    private String name;

    // Konstruktor zur Setzung von Art und Name
    public Tier(String art, String name) {
        this.art = art;
        this.name = name;
    }

    // Getter für Art
    public String getArt() {
        return art;
    }

    // Getter für Name
    public String getName() {
        return name;
    }

    // Setter für Name
    public void setName(String name) {
        this.name = name;
    }
}
