public class FillTable {
    // Define start and end times as class variables
    // #region Class Variables
    private static final String[] START_TIMES = {
            "7:45", "8:35", "9:40", "10:30", "11:20", "12:10", "12:50",
            "13:35", "14:25", "15:15", "16:15", "17:05"
    };

    private static final String[] END_TIMES = {
            "8:30", "9:20", "10:25", "11:15", "12:05", "12:50", "13:30",
            "14:20", "15:10", "16:10", "17:00", "17:50"
    };

    // #region fillTable
    // Example method to fill a timetable with teachers
    private static void fillTable(String[] teacherNames, String day, String[] startTime, String[] endTime,
            int roomIndex) {
        int dayIndex = getDayIndex(day);
        for (int i = 0; i < teacherNames.length; i++) {
            // Room is determined by the caller method
            App.timeTable[roomIndex][dayIndex][i] = new Lesson(37, teacherNames[i], startTime[i], endTime[i], day);
        }
    }

    private static int getDayIndex(String day) {
        switch (day) {
            case "Monday":
                return 0;
            case "Tuesday":
                return 1;
            case "Wednesday":
                return 2;
            case "Thursday":
                return 3;
            case "Friday":
                return 4;
            default:
                return -1; // Invalid day
        }
    }

    // Fill 37 timetable
    // #region table 37
    static void fill37TimeTable() {
        int roomIndex = 0;
        fillTable(new String[] { "Hm", "Py", "Hi", "Hm", "Le", "", "Gi", "Gi", "D", "Ts", "Ts", "" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
    }

    // Fill Room 38 timetable
    // #region table 38
    static void fill38TimeTable() {
        int roomIndex = 1;
        fillTable(new String[] { "Bz", "Bz", "Bz", "Bz", "Bz", "", "Hn", "Hn", "Bu", "Bu", "Hn", "Hn" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Br", "Kg", "Kh", "Re", "Es", "", "Bt", "EW", "FR", "FR", "VW", "VW" },
                "Tuesday", START_TIMES, END_TIMES, roomIndex);
    }

    // Fill Room 39 timetable
    // #region table 39
    static void fill39TimeTable() {
        int roomIndex = 2;
        fillTable(new String[] { "", "", "", "", "", "", "", "", "", "", "", "" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "", "", "", "", "", "", "", "", "", "", "", "" },
                "Tuesday", START_TIMES, END_TIMES, roomIndex);
    }
}

