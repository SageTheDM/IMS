import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    // #region app constants
    private static final Scanner scanner = new Scanner(System.in);
    private static final Teacher[] teachers = new Teacher[Teacher.nameMap.size()];

    // Room channel numbers
    private static final int ROOM_39_NUMBER = 1521262;
    private static final int ROOM_38_NUMBER = 1364580;
    private static final int ROOM_37_NUMBER = 1521263;

    // Date and time constants for Start and End Dates
    private static final String START_DATE = "2024-11-04";
    private static final String END_DATE = "2024-11-08";

    // #region Initialization

    public static String generateLink(int channelNumber, String date, String startTime, String endTime) {
        String baseUrl = "https://api.thingspeak.com/channels/";
        String formattedStartDateTime = date + " " + startTime;
        String formattedEndDateTime = date + " " + endTime;

        return baseUrl + channelNumber + "/feeds.csv?start=" + formattedStartDateTime.replace(" ", "%20")
                + "&end=" + formattedEndDateTime.replace(" ", "%20"); // %20 --> " "

    }

    private static double getDataAverageForMinute(int minute, int hour, int number, String date) {
        // get the url
        String startTime = "";
        if (hour < 10) {
            startTime += "0";
        }
        startTime += String.valueOf(hour);
        startTime += ":";
        if (minute < 10) {
            startTime += "0";
        }
        startTime += String.valueOf(minute);
        String calcStarttime = startTime + ":00";
        String calcEndTime = startTime + "59";

        String url = generateLink(number, date, calcStarttime, calcEndTime);

        double averageCO2 = 0.0;
        List<Co2Data> co2DataList = Co2Data.getData(url);
        for (Co2Data co2Data : co2DataList) {
            averageCO2 += co2Data.getCo2Level();
        }

        return averageCO2 / co2DataList.size(); // Example CO2 average level
    }

    private static void calculateBreakPoints(double[] minuteData, Break calcBreak, Teacher teacher) {
        int duration = calcBreak.getEnd().getMinute() - calcBreak.getStart().getMinute();
        int breakPoints = minuteData.length;
        if (duration == minuteData.length) {
            for (int i = 0; i < duration; i++) {
                if (minuteData[i] < minuteData[i + 1]) {
                    breakPoints--;
                }
            }
        } else
            System.out.println("Unexpected error");
        if (duration > 5) {
            teacher.addPoints(0, breakPoints, 0);
        } else {
            teacher.addPoints(breakPoints, 0, 0);
        }

        // check if next lesson is lunch another teacher or the same and plan
        // accordingly

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
        for (int classrooms = 0; classrooms < 3; classrooms++) {
            for (int weekday = 0; weekday < 5; weekday++) {
                // get the url and data
                // calculate points
            }
        }
        // Loop threw each day with a specific classroom and after the weekdays are over
        // go to the next of the 3 classroms
        // go threw every break calculate the point and give them to the teacher
        // directly
        // remember the point class
        // breakShedule needed

        while (true) {
            int userInput = getUserInput(
                    "Do you want to see how the points were calculated? (Yes 1, No 0; anything is an error)");
            if (userInput == 1) {
                printExplanation();
                // add a more detailed listing of the teacher since points can be broken down
                // further
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
