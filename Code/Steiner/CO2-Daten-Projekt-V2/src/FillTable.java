public class FillTable {
    // #region Constants
    private static final String[] START_TIMES = {
            "7:45", "8:35", "9:40", "10:30", "11:20", "12:10", "12:50",
            "13:35", "14:25", "15:15", "16:15", "17:05"
    };

    private static final String[] END_TIMES = {
            "8:30", "9:20", "10:25", "11:15", "12:05", "12:50", "13:30",
            "14:20", "15:10", "16:10", "17:00", "17:50"
    };

    // #region Helper Methods
    private static void fillTable(String[] teacherShortNames, String day, String[] startTime, String[] endTime,
            int roomIndex) {
        int dayIndex = getDayIndex(day);
        for (int i = 0; i < teacherShortNames.length && i < startTime.length && i < endTime.length; i++) {
            Teacher teacher = new Teacher(teacherShortNames[i]); // Initialize Teacher with shortform
            App.timeTable[roomIndex][dayIndex][i] = new Lesson(roomIndex, teacher.getName(), startTime[i],
                    endTime[i],
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

    // #region Fill 37
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

    // #region Fill 38
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

    // #region Fill 39
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

    static boolean isBreak(int intHour, int intMinute) {
        // Check if the time is between 7 AM and 5 PM
        if (intHour >= 7 && intHour <= 17) {
            // Check if the time falls between any lesson start and end times
            for (int i = 0; i < START_TIMES.length; i++) {
                // Split the start and end times into hours and minutes
                String[] startTime = START_TIMES[i].split(":");
                String[] endTime = END_TIMES[i].split(":");

                int startHour = Integer.parseInt(startTime[0]);
                int startMinute = Integer.parseInt(startTime[1]);
                int endHour = Integer.parseInt(endTime[0]);
                int endMinute = Integer.parseInt(endTime[1]);

                // Check if the given time is during the current lesson
                if ((intHour > startHour || (intHour == startHour && intMinute >= startMinute)) &&
                        (intHour < endHour || (intHour == endHour && intMinute < endMinute))) {
                    return false; // It's not a break, it's during a lesson
                }
            }
            return true; // If no lessons match, it must be a break
        }

        return false; // Time is outside of the school hours (7 AM to 6 PM roughly)
    }

    static String whatBreakIsIt(int intHour, int intMinute) {
        String whatBreak = "";
        for (int i = 0; i < END_TIMES.length; i++) {
            String[] tempEnd = END_TIMES[i].split(":");
            String[] tempStart = START_TIMES[i].split(":");
            if (intHour >= Integer.parseInt(tempStart[0]) && intHour <= Integer.parseInt(tempEnd[0])) {
                if (intMinute >= Integer.parseInt(tempStart[1])
                        && intMinute <= Integer.parseInt(tempEnd[1])) {
                    if (Integer.parseInt(tempEnd[1]) - Integer.parseInt(tempStart[1]) == 5) {
                        whatBreak = "short";
                    } else if (Integer.parseInt(tempEnd[1]) - Integer.parseInt(tempStart[1]) > 5) {
                        whatBreak = "long";
                    } else {
                        whatBreak = "No Break";
                    }
                }

            }
        }
        return whatBreak; // If no break is found, return "No Break"
    }

    static int[] whatTime(int intHour, int intMinute) {
        int[] result = new int[2]; // [most recent end time, next start time]
        result[0] = -1; // Initialize to -1 (no previous end time found)
        result[1] = -1; // Initialize to -1 (no next start time found)

        for (int i = 0; i < END_TIMES.length; i++) {
            // Parse END_TIMES[i]
            String[] endParts = END_TIMES[i].split(":");
            int endHour = Integer.parseInt(endParts[0]);
            int endMinute = Integer.parseInt(endParts[1]);

            // Parse START_TIMES[i]
            String[] startParts = START_TIMES[i].split(":");
            int startHour = Integer.parseInt(startParts[0]);
            int startMinute = Integer.parseInt(startParts[1]);

            // Check for the most recent end time
            if ((intHour > endHour) || (intHour == endHour && intMinute >= endMinute)) {
                result[0] = i; // Track the most recent lesson's end time index
            }

            // Check for the next start time
            if ((intHour < startHour) || (intHour == startHour && intMinute < startMinute)) {
                result[1] = i; // Track the next lesson's start time index
                break; // No need to continue since START_TIMES is sorted
            }
        }

        return result;
    }
}
