public class App {
    public static void main(String[] args) throws Exception {

        SimpleCalendar simpleCalendar = new SimpleCalendar();
        // Aktuelles Datum und Uhrzeit formatieren und ausgeben
        System.out.println("Aktuelles Datum und Uhrzeit:");
        System.out.println(simpleCalendar.getFormattedDate());

        // Zeit manipulieren
        simpleCalendar.add(SimpleCalendar.DAY_OF_MONTH, 5);
        System.out.println("Datum in 5 Tagen:");
        System.out.println(simpleCalendar.getFormattedDate());
    }
}
