import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        int[] array = { 0, 1, 2, 3, 4, 5, 4, -3, -2, 0 };
        ArrayList<Integer> list = new ArrayList<>();

        initializeListFromArray(array, list);
        printList("ArrayList vor Modifikationen:", list);

        addValues(list, 10, -5);
        removeElementAt(list, 1);
        printList("ArrayList nach Modifikationen:", list);

        sortList(list);
        printList("ArrayList nach Sortierung:", list);

        shuffleList(list);
        printList("ArrayList nach dem Mischen:", list);

        printMinMaxValues(list);
    }

    // Initialisiert die ArrayList mit Werten aus dem Array
    private static void initializeListFromArray(int[] array, ArrayList<Integer> list) {
        for (int num : array) {
            list.add(num);
        }
    }

    // Fügt der ArrayList zwei Werte hinzu
    private static void addValues(ArrayList<Integer> list, int value1, int value2) {
        list.add(value1);
        list.add(value2);
    }

    // Entfernt das Element an einer bestimmten Position
    private static void removeElementAt(ArrayList<Integer> list, int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    // Gibt den Inhalt der ArrayList aus
    private static void printList(String message, ArrayList<Integer> list) {
        System.out.println(message);
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Sortiert die ArrayList
    private static void sortList(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    // Mischt die ArrayList
    private static void shuffleList(ArrayList<Integer> list) {
        Collections.shuffle(list);
    }

    // Gibt den maximalen und minimalen Wert der ArrayList aus
    private static void printMinMaxValues(ArrayList<Integer> list) {
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("Maximaler Wert: " + max);
        System.out.println("Minimaler Wert: " + min);
    }
}
