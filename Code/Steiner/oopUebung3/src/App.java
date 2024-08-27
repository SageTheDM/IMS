public class App {

    public static void main(String[] args) {
        String fullName1 = "Peter Muster";
        String fullName3 = "James Cock";

        extractName.splitName(fullName1);

        System.out.println("First Name: " + extractName.firstName);
        System.out.println("Last Name: " + extractName.lastName);

        extractName.splitName(fullName3);
        System.out.println("First Name: " + extractName.firstName);
        System.out.println("Last Name: " + extractName.lastName);
    }
}
