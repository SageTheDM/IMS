import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[] name = { "Emma", "Liam", "Sophia", "Noah", "Olivia", "William", "Ava", "James", "Isabella",
                "Lucas" };
        String[] lastname = { "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker",
                "Schulz", "Hoffmann" };

        for (boolean search = true; search;) {

            String searchName = getInput();
            if (searchName.equals("")) {
                search = false;
                break;
            } else {
                int foundName = getLastname(name, searchName, lastname);
                if (foundName == -1) {
                    System.out.println("Name not found please create a new entry");
                } else
                    System.out.println(name[foundName] + " " + lastname[foundName]);
            }
        }
    }

    public static String getInput() {
        System.out.println("Please enter the name of the person your searching :)");
        System.out.println("to stop searching press enter without input");
        return scan.nextLine();
    }

    public static int getLastname(String[] name, String searchName, String[] lastname) {
        int i;

        for (i = 0; i < name.length; i++) {
            if (searchName.equalsIgnoreCase(name[i])) {
                return i;
            }
        }
        return -1;
    }
}
