import java.util.GregorianCalendar;

public class SimpleCalendar extends GregorianCalendar {

    public String getFormattedDate() {
        int year = get(GregorianCalendar.YEAR);
        int month = get(GregorianCalendar.MONTH) + 1; // Monate sind 0-basiert
        int day = get(GregorianCalendar.DAY_OF_MONTH);
        int hour = get(GregorianCalendar.HOUR_OF_DAY);
        int minute = get(GregorianCalendar.MINUTE);
        int second = get(GregorianCalendar.SECOND);

        return String.format("%02d.%02d.%04d %02d:%02d:%02d", day, month, year, hour, minute, second);
    }
}
