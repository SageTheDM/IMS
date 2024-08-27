public class App {

    // Assuming an interest rate of 5% for demonstration purposes
    public static final double INTEREST_RATE = 0.05;

    public static void main(String[] args) {

        double accountBalance = 1000.0; // Initial account balance
        double creditedInterest = accountBalance * INTEREST_RATE;

        System.out.println("Initial Account Balance: $" + accountBalance);
        System.out.println("Credited Interest at " + (INTEREST_RATE * 100) + "%: $" + creditedInterest);

        // Update account balance with credited interest
        accountBalance += creditedInterest;

        System.out.println("Updated Account Balance: $" + accountBalance);
    }

    public static void getTest() {

    }
}
