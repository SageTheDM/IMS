// Luca Burger
// Aufgabe 12

public class Time {
    int hour;
    int minute;

    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    void add(Time time, Time time2) {
        time.hour += time2.hour;
        time.minute += time2.minute;
    }

    static int subtract(Time time, Time time2) {
        int minute1 = convertToMinute(time);
        int minute2 = convertToMinute(time2);
        return minute1 - minute2;

    }

    static int convertToMinute(Time time) {
        int add = time.hour * 60;
        return time.minute += add;
    }

    static String print(Time myTime) {
        String text = "";
        text += myTime.hour;
        text += ":";
        text += myTime.minute;
        return text;
    }
}
