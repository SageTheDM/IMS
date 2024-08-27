import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Möchtest du etwas bestellen? j/n");
        boolean etwasBestellt = false;
        String orderSomething = scan.nextLine();

        if (orderSomething.equals("j")) {
            System.out.println("Möchtest du ein Burger? j/n");
            orderSomething = scan.nextLine();

            if (orderSomething.equals("j")) {
                System.out.println("Ein Burger wurde bestellt");
                etwasBestellt = true;
            }

            System.out.println("Möchtest du Eiscreme bestellen? j/n");
            orderSomething = scan.nextLine();

            if (orderSomething.equals("j")) {
                System.out.println("Eiscreme wurde bestellt");
                etwasBestellt = true;
            }

        } else {
            System.out.println("Gut so - so bleibst du ihn Form");
        }
        if (!etwasBestellt) {
            System.out.println("Kommen sie wieder wenn Sie etwas bestellen wollen!");
        }
        scan.close();
    }

}