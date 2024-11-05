import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

public class Lesson {
    private int room;
    private String teacherName;
    private String startTime;
    private String endTime;
    private String day;

    // CO2 level tracking
    private List<Integer> co2Levels; // Assuming this is provided during breaks
    private static final int SMALL_BREAK_POINTS = 5;
    private static final int BIG_BREAK_POINT_PER_MINUTE = 1;

    // Define a DateTimeFormatter that accepts both 'HH:mm' and 'H:mm'
    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("H:mm") // Matches '8:30'
            .optionalStart()
            .appendPattern("HH:mm") // Matches '08:30'
            .optionalEnd()
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) // Set default minutes to 0 if not provided
            .toFormatter();

    // Constructor to initialize all fields
    public Lesson(int room, String teacherName, String startTime, String endTime, String day) {
        this.room = room;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    // Getters
    public int getRoom() {
        return room;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDay() {
        return day;
    }

    public boolean isBreak(Lesson nextLesson) {
        LocalTime thisEndTime = LocalTime.parse(endTime, TIME_FORMATTER);
        LocalTime nextStartTime = LocalTime.parse(nextLesson.getStartTime(), TIME_FORMATTER);
        return thisEndTime.equals(nextStartTime);
    }

    public boolean isBigBreak(Lesson nextLesson) {
        LocalTime thisEndTime = LocalTime.parse(endTime, TIME_FORMATTER);
        LocalTime nextStartTime = LocalTime.parse(nextLesson.getStartTime(), TIME_FORMATTER);
        long breakDuration = java.time.Duration.between(thisEndTime, nextStartTime).toMinutes();
        boolean notLastLesson = !nextLesson.getEndTime().equals("17:00");
        boolean isLunchBreak = "Lunch".equals(nextLesson.getTeacherName());
        return breakDuration > 5 && notLastLesson && !isLunchBreak;
    }

    public boolean isTeacherSwitch(Lesson nextLesson) {
        return room == nextLesson.getRoom() && !teacherName.equals(nextLesson.getTeacherName());
    }

    public void setCo2Levels(List<Integer> co2Levels) {
        this.co2Levels = co2Levels;
    }

    public int calculatePoints(Lesson nextLesson) {
        int points = 0;

        // Check for small break
        if (isBreak(nextLesson)) {
            points += calculateSmallBreakPoints();
        }

        // Check for long break
        if (isBigBreak(nextLesson)) {
            points += calculateBigBreakPoints();
        }

        // Check for teacher switch
        if (isTeacherSwitch(nextLesson)) {
            points += 5; // Additional 5 points for switching teachers
        }

        return points;
    }

    private int calculateSmallBreakPoints() {
        if (co2Levels == null || co2Levels.size() < 5)
            return 0;

        boolean continuousDecrease = true;
        for (int i = 1; i < co2Levels.size(); i++) {
            if (co2Levels.get(i) >= co2Levels.get(i - 1)) {
                continuousDecrease = false;
                break;
            }
        }

        return continuousDecrease ? SMALL_BREAK_POINTS : 0;
    }

    private int calculateBigBreakPoints() {
        if (co2Levels == null)
            return 0;

        int points = 0;
        for (int i = 1; i < co2Levels.size(); i++) {
            if (co2Levels.get(i) < co2Levels.get(i - 1)) {
                points += BIG_BREAK_POINT_PER_MINUTE;
            }
        }

        return points;
    }
}