import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in); // Initialize the scanner

    // Constants for rooms and timetable dimensions
    private static final int ROOM_COUNT = 3;
    private static final int DAY_COUNT = 5;
    private static final int LESSON_COUNT = 12;

    // Data sources for different rooms
    private static final List<Data> room39Data = Data.getData("https://api.thingspeak.com/channels/1521262/feeds.csv",
            39);
    private static final List<Data> room38Data = Data.getData("https://api.thingspeak.com/channels/1364580/feeds.csv",
            38);
    private static final List<Data> room37Data = Data.getData("https://api.thingspeak.com/channels/1521263/feeds.csv",
            37);

    // Time table
    public static final Lesson[][][] timeTable = new Lesson[ROOM_COUNT][DAY_COUNT][LESSON_COUNT];

    // Teacher initials and array
    private static final String[] TEACHER_INITIALS = {
            "Bä", "Bd", "Bu", "Cg", "Di", "Do", "Eh", "Es", "Fh", "Gi",
            "Gr", "Hm", "Hi", "Kg", "Kh", "Lz", "Lu", "Or", "Re", "Se",
            "Ts", "Vt", "Zu"
    };
    private static final Teacher[] teachers = new Teacher[TEACHER_INITIALS.length];

    // Initialization of teachers
    private static void initializeTeachers() {
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher(TEACHER_INITIALS[i]);
        }
    }

    // Filling in the timetable
    private static void fillInTimeTable() {
        FillTable.fill37TimeTable();
        FillTable.fill38TimeTable();
        FillTable.fill39TimeTable();
    }

    // Calculate points based on criteria
    private static void calculatePoints() {
        // TODO: Implement point calculation logic based on specific criteria.
        // Example: If a teacher opens the window during a small break (entire break 5
        // points - can
        // be reduced by the amount the window was open).
        // Maximum points for a long break: 10 points.
        // Plus 5 bonus points if the teachers are switching after.
        for (Teacher teacher : teachers) {
            // Implement logic to calculate points for each teacher
            teacher.setPoints(0); // Replace with actual calculation
        }
    }

    // Sort teachers by their points
    private static void sortTeachers() {
        Arrays.sort(teachers, (t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()));
    }

    // Print the teachers and their points
    private static void printTeachers() {
        System.out.println("Teachers and their points:");

        int rank = 1; // Start with rank 1
        int previousPoints = -1; // Track the points of the previous teacher
        int currentRankCount = 0; // Count how many teachers share the same rank

        for (Teacher teacher : teachers) {
            if (teacher.getPoints() != previousPoints) {
                rank += currentRankCount; // Update rank if points are different
                currentRankCount = 1; // Reset count for the new points
            } else {
                currentRankCount++; // Increment count for same points
            }

            // Print the teacher with their rank and points
            System.out.printf("%d. %s - %d points%n", rank, teacher.getName(), teacher.getPoints());
            previousPoints = teacher.getPoints(); // Update previous points
        }
    }

    // Get user input from the console
    private static int getUserInput(String textOutput) {
        System.out.println(textOutput);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt(); // Read user input
    }

    // Print explanation of point calculations
    private static void printExplanation() {
        System.out.println("Point calculation explanation:");
        System.out.println("1. 5 points for keeping the window open during a small break.");
        System.out.println("2. Up to 10 points for long breaks, with deductions for window usage.");
        System.out.println("3. Bonus points for switching teachers.");
    }

    // Print shutdown animation
    private static void printShutDown() {
        System.out.println("Shutting down...");
        for (int i = 3; i > 0; i--) {
            System.out.print(i + "...");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        fillInTimeTable();
        initializeTeachers();
        calculatePoints();
        sortTeachers();
        printTeachers();

        int userInput = getUserInput(
                "Do you want to see how the points were calculated? (Yes 1, No 0; anything is an error)");

        if (userInput == 1) {
            printExplanation();
            printShutDown();
        } else if (userInput == 0) {
            printShutDown();
        } else {
            // Handle invalid input
            System.out.println("Invalid input. Please enter 1 for Yes or 0 for No.");
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
