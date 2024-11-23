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

    // #region Adjust UTC to Switzerland Time
    private void adjustForSwitzerlandTime() {
        hour += 1;

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
