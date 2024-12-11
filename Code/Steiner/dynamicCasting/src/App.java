import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Article> list = new ArrayList<Article>();
        list.add(new Book("11241", 12, "Tolkien", "The Book to rule all books"));
        list.add(new Camera("0101012", 25000, "Fujifilm"));
        list.add(new CD("0345678", 56789, "hello",
                new ArrayList<String>(Arrays.asList("Hello", "World", "THIS IS THE END"))));
        list.add(new MP3("RASPUTIN", 456789, "Rasputin", "lengh"));

        for (Article article : list) {
            article.print();
            if (article instanceof CD) {
                ((CD) article).playTrack();
            }
            System.out.println();
        }
    }
}
