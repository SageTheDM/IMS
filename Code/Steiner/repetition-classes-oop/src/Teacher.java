// The Teacher class represents a teacher with a first name, last name, compensation, and subjects they teach.
public class Teacher {
    // Private fields to store the teacher's first name, last name, compensation,
    // and subjects.
    private String firstname;
    private String lastname;
    private int compensation;
    private String[] subjects;

    // Constructor for initializing a Teacher object with provided details.
    public Teacher(String firstname, String lastname, int compensation, String[] subjects) {
        // Assigning the provided first name to the teacher's firstname field.
        this.firstname = firstname;
        // Assigning the provided last name to the teacher's lastname field.
        this.lastname = lastname;
        // Assigning the provided compensation to the teacher's compensation field.
        this.compensation = compensation;
        // Assigning the provided array of subjects to the teacher's subjects field.
        this.subjects = subjects;
    }

    // Getter method for getting the teacher's first name.
    public String getFirstname() {
        return firstname;
    }

    // Setter method for setting a new first name for the teacher.
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter method for getting the teacher's last name.
    public String getLastname() {
        return lastname;
    }

    // Setter method for setting a new last name for the teacher.
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter method for getting the teacher's compensation.
    public int getCompensation() {
        return compensation;
    }

    // Setter method for setting a new compensation for the teacher.
    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    // Getter method for getting the array of subjects the teacher teaches.
    public String[] getSubjects() {
        return subjects;
    }

    // Setter method for setting a new array of subjects for the teacher.
    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}