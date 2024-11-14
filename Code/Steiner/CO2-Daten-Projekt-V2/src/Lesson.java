public class Lesson {
    // #region Fields
    private int roomNumber;
    private String teacherInitials;
    private String startTime;
    private String endTime;
    private String weekDay;

    // #region Constructor
    public Lesson(int roomNumber, String teacherInitials, String startTime, String endTime, String weekDay) {
        this.roomNumber = roomNumber;
        this.teacherInitials = teacherInitials;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
    }

    // #region Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getTeacherInitials() {
        return teacherInitials;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }
}
