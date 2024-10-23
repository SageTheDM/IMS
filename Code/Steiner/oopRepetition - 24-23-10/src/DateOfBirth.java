// DateOfBirth class to manage birth date and age calculation
class DateOfBirth {
    private int birthYear;
    private int birthMonth;
    private int birthDay;

    // Constructor
    public DateOfBirth(int birthYear, int birthMonth, int birthDay) {
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
    }

    // Method to calculate the age based on the hardcoded current date (23.10.2024)
    public int calculateAge() {
        int currentYear = 2024;
        int currentMonth = 10;
        int currentDay = 23;

        int age = currentYear - birthYear;

        // Adjust the age if the birthday hasn't happened yet this year
        if (birthMonth > currentMonth || (birthMonth == currentMonth && birthDay > currentDay)) {
            age--;
        }
        return age;
    }

    // Method to return the birth date as a string
    public String getBirthDate() {
        return birthDay + "." + birthMonth + "." + birthYear;
    }
}