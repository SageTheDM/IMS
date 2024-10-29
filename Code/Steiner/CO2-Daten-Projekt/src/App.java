import java.util.List;

public class App {
    // Fetch data for rooms
    private List<Data> room39Data = Data.getData("https://api.thingspeak.com/channels/1521262/feeds.csv", 39);
    private List<Data> room38Data = Data.getData("https://api.thingspeak.com/channels/1364580/feeds.csv", 38);
    private List<Data> room37Data = Data.getData("https://api.thingspeak.com/channels/1521263/feeds.csv", 37);

    // Time table
    // [Room 37 (0), 38 (1), or 39 (2)][Day 0-4][Lesson slot 0-11]
    static Lesson[][][] timeTable = new Lesson[3][5][12];

    public static void main(String[] args) {
        fillInTimeTable();

        // Display filled timetable for verification
        for (int room = 0; room < timeTable.length; room++) {
            for (int day = 0; day < timeTable[room].length; day++) {
                System.out.println("Room " + (room + 37) + ", Day " + (day + 1) + ":");
                for (int lesson = 0; lesson < timeTable[room][day].length; lesson++) {
                    Lesson lessonData = timeTable[room][day][lesson];
                    if (lessonData != null) {
                        System.out.println("  Lesson " + (lesson + 1) + ": " + lessonData);
                    } else {
                        System.out.println("  Lesson " + (lesson + 1) + ": No Lesson");
                    }
                }
            }
        }
    }

    private static void fillInTimeTable() {
        // Fill Room 37 timetable
        FillTable.fillRoom37TimeTable();

        // Fill Room 38 timetable
        FillTable.fillRoom38TimeTable();

        // Fill Room 39 timetable
        FillTable.fillRoom39TimeTable();

    }

    private static void fillRoom37TimeTable() {

    }
}
