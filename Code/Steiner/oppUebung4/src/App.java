import java.util.*;

public class App {
    public static void main(String[] args) {
        Object[][] article = {
                { 1, "Banana", 5, "Stk" },
                { 23, "Flour", 2, "KG" },
                { 12, "Milk", 4, "Liters" },
                { 34, "Apple", 10, "Stk" },
                { 45, "Sugar", 1, "KG" },
                { 67, "Eggs", 12, "Stk" },
                { 89, "Rice", 5, "KG" },
                { 21, "Butter", 2, "Packs" },
                { 78, "Orange Juice", 3, "Liters" },
                { 56, "Bread", 2, "Loaves" },
                { 90, "Cheese", 1, "KG" },
                { 32, "Tomato", 8, "Stk" },
                { 11, "Salt", 1, "KG" },
                { 13, "Cocaine", 12, "mg" }
        };

        // Create an array to hold Storage objects
        Storage[] myStorage = new Storage[1000];
        Storage[] myArticles = new Storage[article.length];

        // Initialize 1000 possible storage places
        for (int i = 0; i < myStorage.length; i++) {
            myStorage[i] = initializStorage(); // Initialize storage with default values
        }

        // Create and store Storage objects in the myArticles array
        for (int i = 0; i < article.length; i++) {
            myArticles[i] = createStorage(article[i]);
        }

        // Fill some of the myStorage array with the contents of myArticles
        // For example, place the first few articles into the first few storage slots
        for (int i = 0; i < myArticles.length; i++) {
            if (i < myStorage.length) {
                myStorage[i] = myArticles[i];
            }
        }

        // Print out the details of each Item
        for (Storage storage : myStorage) {
            printItems(storage);
        }
        String search = "Banana";
        Storage foundItems = lookUp(myStorage, search);
        if (foundItems != null) {
            System.out.println("-------------------");
            System.out.println("You searched for " + search);
            printItems(foundItems);
        } else {
            System.out.println("No " + search + " found");
        }
    }

    private static Storage initializStorage() {
        Storage storage = new Storage();
        storage.storageId = 0;
        storage.article.name = "";
        storage.quantaty = 0;
        storage.article.unit = "";
        return storage;
    }

    private static Storage createStorage(Object[] article) {
        Storage storage = new Storage();
        storage.storageId = (int) article[0];
        storage.article.name = (String) article[1];
        storage.quantaty = (int) article[2];
        storage.article.unit = (String) article[3];
        return storage;
    }

    private static void printItems(Storage storage) {
        if (storage.storageId != 0) { // Only print if there's an actual item
            System.out.println("Item on shelf: " + storage.storageId);
            System.out.println("Item name: " + storage.article.name);
            System.out.println("Item(s) on stock: " + storage.quantaty);
            System.out.println("Measured unit: " + storage.article.unit);
            System.out.println("-----------------------------------------");
        }
    }

    private static Storage lookUp(Storage[] myStorage, String name) {
        for (Storage storage : myStorage) {
            if (storage.article.name == name) {
                return storage;
            }
        }
        return null;
    }
}
