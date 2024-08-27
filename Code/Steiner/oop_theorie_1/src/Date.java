import java.time.LocalDate;
import java.time.Period;
import java.time.Month;
import java.util.Locale;
import java.util.Scanner;

public class Date {
    public int day;
    public String month;
    public int year;

    // Method to get the current date as a formatted string
    public String getCurrentDate() {
        LocalDate now = LocalDate.now(); // Get current date only
        return now.toString();
    }

    // Method to calculate the age based on the birthday
    public int calculateAge() {
        int monthNumber = getMonthNumber();
        if (monthNumber == -1) {
            throw new IllegalArgumentException("Invalid month name: " + month);
        }

        LocalDate birthDate = LocalDate.of(year, monthNumber, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    // Method to convert the month name to a month number
    private int getMonthNumber() {
        try {
            Month monthEnum = Month.valueOf(month.toUpperCase(Locale.ENGLISH));
            return monthEnum.getValue();
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    // Method to input and set the date fields (day, month, year)
    public void inputBirthday() {
        Scanner scan = new Scanner(System.in);

        // Input for day
        System.out.println("Enter your birth day (e.g., 16):");
        this.day = scan.nextInt();

        // Input for month with validation loop
        scan.nextLine(); // Consume the newline
        boolean validMonth = false;
        while (!validMonth) {
            System.out.println("Enter your birth month (e.g., November):");
            this.month = scan.nextLine();

            if (getMonthNumber() != -1) {
                validMonth = true;
            } else {
                System.out.println("Invalid month name. Please try again.");
            }
        }

        // Input for year
        System.out.println("Enter your birth year (e.g., 2005):");
        this.year = scan.nextInt();
    }
}
