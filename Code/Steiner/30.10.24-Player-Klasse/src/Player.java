public class Player {
    private int id;
    private String name;
    private static int counter = 1;

    Player(String name) {
        this.id = counter;
        counter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
