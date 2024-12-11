import java.util.ArrayList;

public class CD extends Audio {
    ArrayList<String> tracks = new ArrayList<>();

    public CD(String code, double price, String title, ArrayList<String> tracks) {
        super(code, price, title);
        this.tracks = tracks;
    }

    @Override
    void print() {
        System.out.println("Title: " + title);
        System.out.println("Code: " + super.code + "\nPrice: " + super.price);
        for (String string : tracks) {
            System.out.println(string);
        }
    }

    void playTrack() {
        int i = 1;
        for (String string : tracks) {
            System.out.println("Play track " + i + " " + string + " der CD " + title);
            i++;
        }
    }
}
