import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
    // #region Fields
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    // #region Constructor
    public Date(int day, int month, int year, int hour, int minute) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;

        // Automatically adjust for Switzerland time after initialization
        adjustForSwitzerlandTime();
    }

    // #region Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    // #region Helper Method to Check Daylight Saving Time
    private boolean isDaylightSavingTime() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month - 1, day); // Month is 0-based in Calendar

        // Last Sunday in March (DST starts)
        Calendar lastSundayInMarch = new GregorianCalendar(year, Calendar.MARCH, 31);
        lastSundayInMarch.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        lastSundayInMarch.add(Calendar.DATE, -7); // Go back to last Sunday of March

        // Last Sunday in October (DST ends)
        Calendar lastSundayInOctober = new GregorianCalendar(year, Calendar.OCTOBER, 31);
        lastSundayInOctober.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        lastSundayInOctober.add(Calendar.DATE, -7); // Go back to last Sunday of October

        // Check if the current date is within the DST period
        return calendar.after(lastSundayInMarch) && calendar.before(lastSundayInOctober);
    }

    // #region Adjust UTC to Switzerland Time
    private void adjustForSwitzerlandTime() {
        if (isDaylightSavingTime()) {
            // Switzerland is UTC +2 during DST (CEST)
            hour += 2;
        } else {
            // Switzerland is UTC +1 during Standard Time (CET)
            hour += 1;
        }

        // Adjust if the hour exceeds 24 or falls below 0
        if (hour >= 24) {
            hour -= 24;
            day++;
            if (day > 31) { // Simple month/day rollover, could be more sophisticated
                day = 1;
                month++;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        } else if (hour < 0) {
            hour += 24;
            day--;
            if (day < 1) {
                month--;
                if (month < 1) {
                    month = 12;
                    year--;
                }
                day = 31; // Simple month/day rollover, could be more sophisticated
            }
        }
    }

    // #region toString Override
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
    }
}
