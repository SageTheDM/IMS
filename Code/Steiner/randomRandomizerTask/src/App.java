import java.util.Random;

public class App {
    public static void main(String[] args) {
        int totalSimulations = 1000000;
        int countThirdDrawer = 0;
        int moneyInDrawer = 0;

        Random random = new Random();

        for (int i = 0; i < totalSimulations; i++) {
            // Simulate whether the Euro is in the desk (50% probability)
            boolean euroInDesk = random.nextBoolean();
            if (euroInDesk)

                // If the Euro is in the desk, it is equally likely to be in any drawer
                if (euroInDesk) {
                    // Controll if it 50%
                    moneyInDrawer++;
                    // Simulate searching the drawers
                    int randomNumber = random.nextInt(3);
                    switch (randomNumber) {
                        
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            countThirdDrawer++;
                            break;
                        default:
                            break;
                    }
                }
        }

        // Calculate the probability based on the simulation results
        double probability = (double) countThirdDrawer / totalSimulations;
        double probabilityCash = (double) moneyInDrawer / totalSimulations;

        System.out.println("Estimated Probability: " + (probability * 100) + "%");
        System.out.println("Estimated Probability for money: " + (probabilityCash * 100) + "%");

    }
}
