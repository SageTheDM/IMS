public class Date {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    // Constructor to parse date string
    public Date(String dateStr) {
        String[] dateTime = dateStr.split(" ");
        String[] dateParts = dateTime[0].split("-");
        String[] timeParts = dateTime[1].split(":");

        this.year = Integer.parseInt(dateParts[0]);
        this.month = Integer.parseInt(dateParts[1]);
        this.day = Integer.parseInt(dateParts[2]);
        this.hour = Integer.parseInt(timeParts[0]);
        this.minute = Integer.parseInt(timeParts[1]);

        // Adjust for Switzerland time
        adjustForSwitzerlandTime();
    }

    // Constructor to create date with fixed numeric values
    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;

        // Adjust for Switzerland time
        adjustForSwitzerlandTime();
    }

    // Adjust time for Switzerland timezone (UTC+1 or UTC+2 during daylight saving
    // time)
    private void adjustForSwitzerlandTime() {
        // Switzerland time adjustment logic (simplified version)
        // For simplicity, this doesn't handle daylight saving time changes but adjusts
        // based on UTC+1
        this.hour += 1; // Assuming fixed UTC+1 offset for simplicity
        if (this.hour >= 24) {
            this.hour -= 24;
            this.day += 1;
        }
    }

    // Getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    // Method to print date in a readable format
    public String toString() {
        return String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
    }
}
