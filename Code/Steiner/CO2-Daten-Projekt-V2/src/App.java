import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    // #region Constants
    private static final Scanner scanner = new Scanner(System.in);
    private static final int ROOM_COUNT = 3;
    private static final int DAY_COUNT = 5;
    private static final int LESSON_COUNT = 12;

    public static final Lesson[][][] timeTable = new Lesson[ROOM_COUNT][DAY_COUNT][LESSON_COUNT];
    private static final Teacher[] teachers = new Teacher[Teacher.nameMap.size()];

    // URLs for fetching CO2 data
    private static final String ROOM_39_URL = "https://api.thingspeak.com/channels/1521262/feeds.csv?results=8000";
    private static final String ROOM_38_URL = "https://api.thingspeak.com/channels/1364580/feeds.csv?results=8000";
    private static final String ROOM_37_URL = "https://api.thingspeak.com/channels/1521263/feeds.csv?results=8000";

    private static final List<Co2Data> room39Data = Co2Data.getData(ROOM_39_URL, 39);
    private static final List<Co2Data> room38Data = Co2Data.getData(ROOM_38_URL, 38);
    private static final List<Co2Data> room37Data = Co2Data.getData(ROOM_37_URL, 37);

    // #region Initialization
    private static void initializeTeachers() {
        int index = 0;
        for (String initial : Teacher.nameMap.keySet()) {
            teachers[index++] = new Teacher(initial);
        }
    }

    private static void fillInTimeTable() {
        FillTable.fill37TimeTable();
        FillTable.fill38TimeTable();
        FillTable.fill39TimeTable();
    }

    // #region Calculation
    private static void calculatePoints(List<Co2Data> data) {
        for (Co2Data co2Data : data) {
            Date temp = co2Data.getDate();
            int intHour = temp.getHour();
            int intMinute = temp.getMinute();
            int intDay = temp.getDay();
            if (FillTable.isBreak(intHour, intMinute)) {
                String whatBreak = FillTable.whatBreakIsIt(intHour, intMinute, intDay);

                switch (whatBreak) {
                    case "short":
                        calculateFiveMinuteBreakPoints(co2Data);
                        break;
                    case "long":
                        calculateLongerBreakPoints(co2Data);
                        break;

                    default:
                        break;
                }
            }
        }
    }

    private static int calculateFiveMinuteBreakPoints(Co2Data data) {
        calculateBonusPoints(data);
        return 5;
    }

    private static int calculateLongerBreakPoints(Co2Data data) {
        calculateBonusPoints(data);
        return 10;
    }

    private static int calculateBonusPoints(Co2Data data) {
        return 5;
    }

    // #region Sorting Printing
    private static void sortTeachers() {
        Arrays.sort(teachers,
                (a, b) -> Integer.compare(b.getPoints().getTotalPoints(), a.getPoints().getTotalPoints()));
    }

    private static void printTeachers() {
        int rank = 1;
        int previousPoints = -1;
        int currentRank = 1;

        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            int teacherPoints = teacher.getPoints().getTotalPoints();

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

    // #region User Interaction
    private static int getUserInput(String textOutput) {
        System.out.println(textOutput);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    private static void printExplanation() {
        System.out.println("Point calculation explanation:");
        System.out.println("1. Up to 5 points for keeping the window open during a small pause.");
        System.out.println("2. Up to 10 points for long pauses, depending on window usage.");
        System.out.println("3. 5 bonus points for teacher switches in the room.");
    }

    private static void printShutDown() {
        System.out.println("Shutting down...");
        for (int i = 3; i > 0; i--) {
            System.out.print(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Goodbye!");
    }

    // @TODO: remove this before hand-in deadline
    public static void debbugingValueLists(List<Co2Data> data) {
        // Debugging co2Data
        int index = 0;
        for (Co2Data a : room37Data) {
            System.out.println(a.toString());
            index++;
        }

        System.out.println("-----------------");
        System.out.println(index);
    }

    // #region Main
    public static void main(String[] args) {
        boolean debbugingList = false;
        if (debbugingList) {
            debbugingValueLists(room37Data);
            // debbugingValueLists(room38Data);
            // debbugingValueLists(room39Data);
        } else {
            System.out.println("Calculations in process please do not shut off...");
            fillInTimeTable();
            initializeTeachers();
            calculatePoints(room37Data);
            calculatePoints(room38Data);
            calculatePoints(room39Data);
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
}
