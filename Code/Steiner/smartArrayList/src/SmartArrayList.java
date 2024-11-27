import java.util.ArrayList;

public class SmartArrayList<T> extends ArrayList<T> {
    public void printElements() {
        System.out.print("Output of the list:");
        for (T object : this) {
            System.out.print(" " + object + ",");
        }
    }
}
