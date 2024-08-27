
public class extractName {
    public static String firstName;
    public static String lastName;

    public static void splitName(String fullName) {

        String[] parts = fullName.split(" ");

        if (parts.length == 2) {
            firstName = parts[0];
            lastName = parts[1];
        } else {
            System.out.println("Error");
        }
    }
}
