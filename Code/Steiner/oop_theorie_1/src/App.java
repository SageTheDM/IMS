// App.java
public class App {
    public static void main(String[] args) {
        Date my_birthday = new Date();

        // Input birthday using the Date class method
        my_birthday.inputBirthday();

        // Print the entered birthday
        System.out.println("Your birthday: " + my_birthday.day + " " + my_birthday.month + " " + my_birthday.year);

        // Calculate and print the age
        int age = my_birthday.calculateAge();
        System.out.println("Your age is: " + age);
    }
}
