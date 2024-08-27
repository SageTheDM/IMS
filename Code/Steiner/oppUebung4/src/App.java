public class App {
    public static void main(String[] args) throws Exception {
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
                { 11, "Salt", 1, "KG" }

        };

        // Create an array to hold Storage objects
        Storage[] myStorage = new Storage[article.length];

        // Create and store Storage objects in the array
        for (int i = 0; i < article.length; i++) {
            myStorage[i] = createStorage(article[i]);
        }

        // Print out the details of each Item
        for (Storage storage : myStorage) {
            printItems(storage);
        }

    }

    private static Storage createStorage(Object[] article) {
        Storage storage = new Storage();
        storage.storageId = (int) article[0];
        storage.name = (String) article[1];
        storage.unit.quantaty = (int) article[2];
        storage.unit.unit = (String) article[3];
        return storage;
    }

    private static void printItems(Storage storage) {
        System.out.println("Item on shelf: " + storage.storageId);
        System.out.println("Item name: " + storage.name);
        System.out.println("Item(s) on stock: " + storage.unit.quantaty);
        System.out.println("Measured unit: " + storage.unit.unit);
        System.out.println("-----------------------------------------");
    }
}
