public class Lesson {
    private int roomNumberNumber;
    private String teacherInitials;
    private String startTime;
    private String endTime;
    private String weekweekDay;

    // Constructor to initialize all fields
    public Lesson(int roomNumber, String teacherInitials, String startTime, String endTime, String weekweekDay) {
        this.roomNumberNumber = roomNumber;
        this.teacherInitials = teacherInitials;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekweekDay = weekweekDay;
    }

    // Getters
    public int getroomNumber() {
        return roomNumberNumber;
    }

    public String getteacherInitials() {
        return teacherInitials;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getweekDay() {
        return weekweekDay;
    }
}