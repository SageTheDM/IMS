public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        if (hour >= 1 && hour <= 24 && minute >= 1 && minute <= 60) {
            this.hour = hour;
            this.minute = minute;
        } else {
            System.out.println("Failed to initialize the hour");
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
