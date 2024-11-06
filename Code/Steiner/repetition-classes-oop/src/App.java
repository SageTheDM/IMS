
// Main application class where we create a Teacher object and display some
// info.
public class App {
    public static void main(String[] args) throws Exception {
        // Sample data for creating a Teacher object.
        String firstname = "Karl";
        String lastname = "Marx";
        int compensation = 1000000;
        String[] subjects = { "Economics", "Math", "German" };

        // Creating a Teacher object using the data above.
        Teacher teacher = new Teacher(firstname, lastname, compensation, subjects);

        // Printing the teacher's full name.
        System.out.println("Teacher: " + teacher.getFirstname() + " " + teacher.getLastname());

        // Printing the teacher's compensation.
        System.out.println("Compensation: " + teacher.getCompensation());

        // Printing the subjects the teacher teaches.
        System.out.print("Subjects: ");
        // Loop through each subject in the array and print it.
        for (String subject : teacher.getSubjects()) {
            System.out.print(subject + " ");
        }
    }
}
