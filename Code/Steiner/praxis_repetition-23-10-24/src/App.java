public class App {
    public static void main(String[] args) {
        // Customer 1
        Customer customer1 = createCustomer("Hans", "Müller", "user1", "password123");
        logIn(customer1, "user1", "password123");

        // Customer 2
        Customer customer2 = createCustomer("Jack", "Stone", "user2", "password456");
        logIn(customer2, "user2", "password456");

        // Retrieve names and print them
        printCustomerNames(customer1);
        printCustomerNames(customer2);
    }

    private static Customer createCustomer(String firstName, String lastName, String user, String password) {
        Customer customer = new Customer(user, password);
        customer.setForname(firstName);
        customer.setSurname(lastName);
        return customer;
    }

    private static void printCustomerNames(Customer customer) {
        String[] names = retrieveNames(customer);
        System.out.println("Customer: " + names[0] + " " + names[1]);
    }

    private static String[] retrieveNames(Customer customer) {
        return new String[] { customer.getForname(), customer.getSurname() };
    }

    private static void logIn(Customer customer, String user, String password) {
        if (customer.login(user, password)) {
            System.out.println("Logged in successfully.");
        } else {
            System.out.println("Login failed.");
        }
    }
}
