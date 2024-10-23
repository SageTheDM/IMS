// Person class that uses the DateOfBirth class
class Person {
    private String name;
    private DateOfBirth dateOfBirth; // Using DateOfBirth for birth date management
    private String address;

    // Constructor
    public Person(String name, DateOfBirth dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    // Method to introduce the person
    public void introduce() {
        System.out.println("Hi, I'm " + name + ". I was born on " + dateOfBirth.getBirthDate() + " and I am "
                + dateOfBirth.calculateAge() + " years old.");
    }

    // Method to list the person's details
    public void listInformation() {
        System.out.println("Name: " + name);
        System.out.println("Birth Date: " + dateOfBirth.getBirthDate());
        System.out.println("Age: " + dateOfBirth.calculateAge());
        System.out.println("Address: " + address);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}