import java.util.Arrays;
import java.util.Scanner;

// Main application class
public class App {
    private static final Scanner scanner = new Scanner(System.in); // Initialize the scanner

    // Constants for rooms and timetable dimensions
    private static final int ROOM_COUNT = 3;
    private static final int DAY_COUNT = 5;
    private static final int LESSON_COUNT = 12; // Updated to match the lengths of START_TIMES and END_TIMES

    // Time table
    public static final Lesson[][][] timeTable = new Lesson[ROOM_COUNT][DAY_COUNT][LESSON_COUNT];

    // Teacher initials and array
    private static final String[] TEACHER_INITIALS = {
            "Bd", "Bu", "Cg", "Do", "Eh", "Fh", "Gi", "Gr", "Hm", "Hi",
            "Kg", "Kh", "Lz", "Lu", "Or", "Re", "Se", "Ts", "Vt", "Zu"
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
        for (int day = 0; day < DAY_COUNT; day++) {
            for (int room = 0; room < ROOM_COUNT; room++) {
                for (int lessonIndex = 0; lessonIndex < LESSON_COUNT - 1; lessonIndex++) {
                    Lesson currentLesson = timeTable[room][day][lessonIndex];
                    Lesson nextLesson = timeTable[room][day][lessonIndex + 1];

                    // Ensure both current and next lessons are not null
                    if (currentLesson != null && nextLesson != null) {
                        // Calculate points for the current lesson based on the next lesson
                        int points = currentLesson.calculatePoints(nextLesson);

                        // Update the points for the teacher associated with the current lesson
                        String currentTeacherName = currentLesson.getTeacherName();
                        for (Teacher teacher : teachers) {
                            if (teacher.getName().equals(currentTeacherName)) {
                                teacher.addPoints(points); // Update teacher points
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    // Sort teachers by their points
    private static void sortTeachers() {
        Arrays.sort(teachers, (t1, t2) -> Integer.compare(t2.getPoints(), t1.getPoints()));
    }

    // Print the teachers and their points
    private static void printTeachers() {
        System.out.println("Teachers and their points:");
        int rank = 1;
        int previousPoints = -1;
        int currentRankCount = 0;

        for (Teacher teacher : teachers) {
            if (teacher.getPoints() != previousPoints) {
                rank += currentRankCount;
                currentRankCount = 1;
            } else {
                currentRankCount++;
            }

            System.out.printf("%d. %s - %d points%n", rank, teacher.getName(), teacher.getPoints());
            previousPoints = teacher.getPoints();
        }
    }

    // Get user input from the console
    private static int getUserInput(String textOutput) {
        System.out.println(textOutput);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Print explanation of point calculations
    private static void printExplanation() {
        System.out.println("Point calculation explanation:");
        System.out.println("1. Up to 5 points for keeping the window open during a small break.");
        System.out.println(
                "2. Up to 10 points for long breaks, depending on the duration the window is open and deductions for usage.");
        System.out.println("3. Additional 5 bonus points for switching teachers if another teacher is in the room.");
    }

    // Print shutdown animation
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
            System.out.println("Invalid input. Please enter 1 for Yes or 0 for No.");
        }

        scanner.close();
    }
}
