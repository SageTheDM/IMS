public class Break {
    private Time start;
    private Time end;
    private Teacher teacher;
    private int room;

    public Break(Time start, Time end, Teacher teacher, int room) {
        this.start = start;
        this.end = end;
        this.teacher = teacher;
        this.room = room;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
