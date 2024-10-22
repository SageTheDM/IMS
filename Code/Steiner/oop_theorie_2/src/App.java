public class App {
    public static void main(String[] args) throws Exception {
        // Create an array of Person objects
        Person[] persons = new Person[5];

        // Initialize the Person objects
        persons[0] = new Person("Hans", 2012);
        persons[1] = new Person("Peter", 2011);
        persons[2] = new Person("Jochen", 2013);
        persons[3] = new Person("Christian", 2050);
        persons[4] = new Person("Tobias", 1932);

        // Print each person
        for (Person person : persons) {
            person.printPerson();
        }

        int sumAge = 0;
        for (Person person : persons) {
            sumAge += person.getAge();
        }

        System.out.println("The sum of the age of all people is: " + sumAge);
    }
}
