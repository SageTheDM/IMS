public class Lesson {
    private int room;
    private String teacherName;
    private String startTime;
    private String endTime;
    private String day;

    // Constructor to initialize all fields
    public Lesson(int room, String teacherName, String startTime, String endTime, String day) {
        this.room = room;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

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
}