public class TimeTable {
    private String[][] shortTeacher;

    public TimeTable(int roomIndex) {
        shortTeacher = new String[11][5]; // 11 lessons, 5 weekdays
        initializeTimeTable(roomIndex);
    }

    private void initializeTimeTable(int roomIndex) {
        switch (roomIndex) {
            case 0: // Room 37
                fillRoom37();
                break;
            case 1: // Room 38
                fillRoom38();
                break;
            case 2: // Room 39
                fillRoom39();
                break;
            default:
                throw new IllegalArgumentException("Invalid room index");
        }
    }

    private void fillRoom37() {
        shortTeacher = new String[][] {
                { "Hm", "Ts", "Lu", "Gi", "Kp" },
                { "Hm", "Ts", "Lu", "Gi", "KP" },
                { "Hi", "Ts", "Lu", "Ba", "Or" },
                { "Hm", "Ts", "Lu", "Ba", "Vt" },
                { "Hm", "Le", "Cg", "Ba", "Vt" },
                { "Lunch", "Lunch", "Lunch", "Lunch", "Lunch" },
                { "Bd", "Lunch", "Se", "Bd", "Lunch" },
                { "Gi", "Fh", "Se", "Du", "Du" },
                { "Gi", "Fh", "Se", "Lz", "Du" },
                { "Ts", "Fh", "Se", "Lz", "Du" },
                { "Ts", "Fh", "Se", "", "" }
        };
    }

    private void fillRoom38() {
        shortTeacher = new String[][] {
                { "Bz", "Kg", "Cg", "Do", "" },
                { "Bz", "Kg", "Cg", "Do", "Hu" },
                { "Bz", "Eh", "Cg", "Gr", "Ge" },
                { "Bz", "Re", "Cg", "Gr", "Eh" },
                { "Bz", "Re", "Es", "Or", "Eh" },
                { "Lunch", "Lunch", "Lunch", "Lunch", "Lunch" },
                { "Lunch", "Lunch", "Lunch", "Lunch", "Bu" },
                { "Hn", "Bt", "Cg", "Bu", "Eh" },
                { "Hn", "Kh", "Cg", "Bu", "Eh" },
                { "Bu", "Kh", "", "Zu", "" },
                { "Hn", "", "", "", "" }
        };
    }

    private void fillRoom39() {
        shortTeacher = new String[][] {
                { "Bd", "Do", "Cg", "Bd", "Gi" },
                { "Bd", "Do", "Cg", "Bd", "Gi" },
                { "Bd", "Zu", "Cg", "Bd", "Gr" },
                { "Bd", "Zu", "Cg", "Bd", "Gr" },
                { "Bd", "Zu", "Bu", "Or", "Gi" },
                { "Lunch", "Lunch", "Lunch", "Lunch", "Lunch" },
                { "Lunch", "Lunch", "Lunch", "Lunch", "Lunch" },
                { "Lu", "Se", "Gi", "Le", "Hi" },
                { "Lu", "Se", "Gi", "Le", "Hi" },
                { "Lu", "Se", "Gi", "Le", "Hi" },
                { "Lu", "Se", "Gi", "", "" }
        };
    }

    public String getLesson(int lesson, int day) {
        if (lesson < 0 || lesson >= 11 || day < 0 || day >= 5) {
            throw new IllegalArgumentException("Invalid lesson or day");
        }
        return shortTeacher[lesson][day];
    }
}
