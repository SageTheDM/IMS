import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String firstName = inputText("Give me your firstname");
        String lastName = inputText("Give me your lastname");
        System.out.println("Hallo " + firstName + " " + lastName + " prepare to die!");
    }

    public static String inputText(String input) {
        System.out.println(input);
        String output = scan.nextLine();
        return output;
    }
}
