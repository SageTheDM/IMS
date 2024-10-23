// Main class with methods to create, modify, and display a person
public class Main {
    public static void main(String[] args) {
        // Create a Person object with all parameters
        Person person = createPerson();

        // Print the introduction and list of information
        printPersonDetails(person);

        // Modify the person and return a new object
        Person updatedPerson = modifyPerson(person, "Bob", "789 Oak Street");

        // Print the updated person information
        System.out.println("\nAfter modification:");
        printPersonDetails(updatedPerson);
    }

    // Method to create and return a Person object
    public static Person createPerson() {
        DateOfBirth dob = new DateOfBirth(1994, 6, 15); // Example birth date
        return new Person("Alice", dob, "1234 Elm Street");
    }

    // Method to print a person's details
    public static void printPersonDetails(Person person) {
        person.introduce(); // Print the introduction
        person.listInformation(); // Print the full list of details
    }

    // Method to modify a person object and return the modified person (custom
    // object as return type)
    public static Person modifyPerson(Person originalPerson, String newName, String newAddress) {
        // Modify the person's details and return the modified object
        originalPerson.setName(newName); // Update the name
        originalPerson.setAddress(newAddress); // Update the address
        return originalPerson; // Return the modified object
    }
}
