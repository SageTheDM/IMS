public class App {
    public static void main(String[] args) {
        // (Kein) Casting notwendig
        int intValue = 42;
        double doubleValue = intValue;

        System.out.println("int value: " + intValue);
        System.out.println("double value: " + doubleValue);

        // Casting nötig
        double largeDoubleValue = 123.456;
        int intValueFromDouble = (int) largeDoubleValue;

        System.out.println("double value: " + largeDoubleValue);
        System.out.println("int value from double: " + intValueFromDouble);
    }
}
