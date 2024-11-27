public class App {
    public static void main(String[] args) throws Exception {
        SmartArrayList<Integer> intList = new SmartArrayList<Integer>();
        SmartArrayList<String> stringList = new SmartArrayList<String>();
        intList.add(10);
        intList.add(20);
        intList.add(5);

        stringList.add("Apfel");
        stringList.add("Banane");
        stringList.add("Kirsche");

        System.out.println("Integer-Liste:");
        intList.printElements();
        System.out.println("\nString-Liste:");
        stringList.printElements();
    }
}
