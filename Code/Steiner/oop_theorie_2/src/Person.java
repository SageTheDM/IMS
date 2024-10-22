import java.time.LocalDate;

class Person {
    private String name;
    private int age;

    Person(String name, int yearOfBirth) {
        this.name = name;
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        this.age = year - yearOfBirth;
        if (this.age < 0) {
            this.age = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printPerson() {
        System.out.println(name + " " + age);
    }
}
