public class BreakSchedule {
    private static final String[] START_SMALL_BREAK = {
            "8:30", "10:25", "11:15", "12:05", "13:30", "14:20", "16:10", "17:00", "17:50"
    };

    private static final String[] END_SMALL_BREAK = {
            "8:35", "10:30", "11:20", "12:10", "13:35", "14:25", "16:15", "17:05", "17:55"
    };

    private static final String[] START_LONG_BREAK = {
            "9:20", "15:10"
    };

    private static final String[] END_LONG_BREAK = {
            "9:40", "15:25"
    };

    private static final Break[] SMALL_BREAKS;
    private static final Break[] LONG_BREAKS;

    static {
        SMALL_BREAKS = createBreaks(START_SMALL_BREAK, END_SMALL_BREAK);
        LONG_BREAKS = createBreaks(START_LONG_BREAK, END_LONG_BREAK);
    }

    private static Break[] createBreaks(String[] startTimes, String[] endTimes) {
        Break[] breaks = new Break[startTimes.length];
        for (int i = 0; i < startTimes.length; i++) {
            // Append ":00" to include seconds
            String startTimeWithSeconds = startTimes[i];
            String endTimeWithSeconds = endTimes[i];

            Time start = Time.valueOf(startTimeWithSeconds);
            Time end = Time.valueOf(endTimeWithSeconds);
            breaks[i] = new Break(start, end);
        }
        return breaks;
    }

    public static Break[] getSmallBreaks() {
        return SMALL_BREAKS;
    }

    public static Break[] getLongBreaks() {
        return LONG_BREAKS;
    }
}