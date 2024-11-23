import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class App {
    // #region app constants
    private static final Teacher[] teachers = new Teacher[Teacher.nameMap.size()];

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

    // Room channel numbers
    private static final int ROOM_39_NUMBER = 1521262;
    private static final int ROOM_38_NUMBER = 1364580;
    private static final int ROOM_37_NUMBER = 1521263;

    // Date and time constants
    private static final int START_YEAR = 2024;
    private static final int START_MONTH = 11; // November
    private static final int START_DAY = 4;
    private static final int START_HOUR = 0;
    private static final int START_MINUTE = 0;

    private static final int END_YEAR = 2024;
    private static final int END_MONTH = 11; // November
    private static final int END_DAY = 8;
    private static final int END_HOUR = 23;
    private static final int END_MINUTE = 59;

    // Formatting the start and end date with time
    private static final String START_DATE = String.format("%d-%02d-%02d%%20%02d:%02d:00",
            START_YEAR, START_MONTH, START_DAY, START_HOUR, START_MINUTE);
    private static final String END_DATE = String.format("%d-%02d-%02d%%20%02d:%02d:00",
            END_YEAR, END_MONTH, END_DAY, END_HOUR, END_MINUTE);

    // #region Initialization
    private static String createUrl(int ROOM_X_NUMBER) {
        return String.format("https://api.thingspeak.com/channels/%d/feeds.csv?start=%s&end=%s",
                ROOM_X_NUMBER, START_DATE, END_DATE);
    }
    // #endregion

    private static void getDataForBreak() {
        // Co2Data[Wochentag][Room 37, 38 or 39]
        Co2Data[][][] data = new Co2Data[5][3][11];

        // Placeholder logic: Retrieve data for CO2 during breaks
        // This should be replaced with the actual logic to get the data from ThingSpeak
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 11; k++) {
                    data[i][j][k] = new Co2Data(null, k); // Placeholder CO2 data
                }
            }
        }
    }

    private static double getDataAverageForMinute(String time) {
        // Placeholder logic to calculate average CO2 levels
        return 400.0; // Example CO2 average level
    }

    private static void initializeTeachers() {
        int index = 0;
        for (String initial : Teacher.nameMap.keySet()) {
            Teacher teacher = new Teacher(initial);
            Points points = new Points(); // Initialize Points object for each teacher
            teacher.setPoints(points.getLongerBreak(), points.getBonusPoints(), points.getFiveMinuteBreak());
            teachers[index++] = teacher;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    // #region User Interaction
    private static int getUserInput(String textOutput) {
        System.out.println(textOutput);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            scanner.next(); // Clear invalid input
        }
    }

    // #region Explanation
    private static void printExplanation() {
        System.out.println("Point calculation explanation:");
        System.out.println("1. Up to 5 points for keeping the window open during a small pause.");
        System.out.println("2. Up to 10 points for long pauses, depending on window usage.");
        System.out.println("3. 5 bonus points for teacher switches in classrooms.");
        System.out.println("4. Deduct points if CO2 levels are too high.");
    }

    // #region shutdown
    private static void printShutDown() {
        System.out.println("Shutting down...");
        for (int i = 3; i > 0; i--) {
            System.out.print(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // #TODO: remove this before hand-in deadline
    public static void debbugingValueLists(List<Co2Data> data) {
        // Debugging co2Data
        int index = 0;
        for (Co2Data a : data) {
            System.out.println(a.toString());
            index++;
        }

        System.out.println("-----------------");
        System.out.println(index);
    }

    // #TODO
    // #region Print & sort
    private static void sortTeachers() {
        // Sorting teachers by total points (implement sorting logic based on points)
        Arrays.sort(teachers,
                (a, b) -> Integer.compare(b.getPoints().getTotalPoints(), a.getPoints().getTotalPoints()));
    }

    private static void printTeachers() {
        int rank = 1;
        int previousPoints = -1;
        int currentRank = 1;

        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            int teacherPoints = teacher.getPoints().getTotalPoints(); // Assuming points are available in getPoints()

            if (teacherPoints == previousPoints) {
                System.out.println(currentRank + ". " + teacher.getName() + " " + teacherPoints);
            } else {
                if (i > 0) {
                    rank += (i - (currentRank - 1));
                }
                currentRank = rank;
                System.out.println(rank + ". " + teacher.getName() + " " + teacherPoints);
            }

            previousPoints = teacherPoints;
        }
    }

    // #region Main
    public static void main(String[] args) {
        System.out.println("Calculations in process please do not shut off...");
        initializeTeachers();

        sortTeachers();
        printTeachers();
        while (true) {
            int userInput = getUserInput(
                    "Do you want to see how the points were calculated? (Yes 1, No 0; anything is an error)");

            if (userInput == 1) {
                printExplanation();
                printShutDown();
                break;
            } else if (userInput == 0) {
                printShutDown();
                break;
            } else {
                System.out.println("Invalid input. Please enter 1 for Yes or 0 for No.");
            }
        }
        scanner.close();
    }
}
