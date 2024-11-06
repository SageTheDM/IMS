
public class FillTable {
    private static final String[] START_TIMES = {
            "7:45", "8:35", "9:40", "10:30", "11:20", "12:10", "12:50",
            "13:35", "14:25", "15:15", "16:15", "17:05"
    };

    private static final String[] END_TIMES = {
            "8:30", "9:20", "10:25", "11:15", "12:05", "12:50", "13:30",
            "14:20", "15:10", "16:10", "17:00", "17:50"
    };

    private static void fillTable(String[] teacherShortNames, String day, String[] startTime, String[] endTime,
            int roomIndex) {
        int dayIndex = getDayIndex(day);
        for (int i = 0; i < teacherShortNames.length && i < startTime.length && i < endTime.length; i++) {
            Teacher teacher = new Teacher(teacherShortNames[i]); // Initialize Teacher with shortform
            App.timeTable[roomIndex][dayIndex][i] = new Lesson(roomIndex, teacher.getName(), startTime[i], endTime[i],
                    day);
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
                return -1;
        }
    }

    static void fill37TimeTable() {
        int roomIndex = 0;
        fillTable(new String[] { "Hm", "Hm", "Hi", "Hm", "Hm", "Lunch", "Bd", "Gi", "Gi", "Ts", "Ts", "" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Ts", "Ts", "Ts", "Ts", "Le", "Lunch", "Lunch", "Fh", "Fh", "Fh", "Fh", "" },
                "Tuesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Lu", "Lu", "Lu", "Lu", "Cg", "Cg", "Lunch", "Se", "Se", "Se", "Se", "" },
                "Wednesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Gi", "Gi", "Ba", "Ba", "Ba", "Lunch", "Bd", "Du", "Lz", "Lz" },
                "Thursday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Kp", "KP", "Or", "Vt", "Vt", "Lunch", "Lunch", "Du", "Du", "Du", "", "" },
                "Friday", START_TIMES, END_TIMES, roomIndex);
    }

    static void fill38TimeTable() {
        int roomIndex = 1;
        fillTable(new String[] { "Bz", "Bz", "Bz", "Bz", "Bz", "Lunch", "Lunch", "Hn", "Hn", "Bu", "Hn", "Hn" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Kg", "Kg", "Eh", "Re", "Re", "Lunch", "Lunch", "Bt", "Kh", "Kh", "", "" },
                "Tuesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Cg", "Cg", "Cg", "Cg", "Es", "Lunch", "Lunch", "Cg", "Cg", "", "", "" },
                "Wednesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Do", "Do", "Gr", "Gr", "Or", "Lunch", "Lunch", "Bu", "Bu", "Zu", "", "" },
                "Thursday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "", "Hu", "Ge", "Eh", "Eh", "Bu", "Lunch", "Eh", "Eh", "", "", "" },
                "Friday", START_TIMES, END_TIMES, roomIndex);
    }

    static void fill39TimeTable() {
        int roomIndex = 2;
        fillTable(new String[] { "Bd", "Bd", "Bd", "Bd", "Bd", "Lunch", "Lunch", "Lu", "Lu", "Lu", "Lu", "" },
                "Monday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Do", "Do", "Zu", "Zu", "Zu", "Lunch", "Lunch", "Se", "Se", "Se", "Se", "" },
                "Tuesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Cg", "Cg", "Cg", "Cg", "Bu", "Lunch", "Lunch", "Gi", "Gi", "Gi", "Gi", "" },
                "Wednesday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Bd", "Bd", "Bd", "Bd", "Or", "Lunch", "Lunch", "Le", "Le", "Le", "", "" },
                "Thursday", START_TIMES, END_TIMES, roomIndex);
        fillTable(new String[] { "Gi", "Gi", "Gr", "Gr", "Gi", "Lunch", "Lunch", "Hi", "Hi", "Hi", "", "" },
                "Friday", START_TIMES, END_TIMES, roomIndex);
    }
}