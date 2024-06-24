

        // Variables

        int minRange = 0;
        int maxRange = 1000;
        int sum = 0;
        int smallNumber = 0;
        int bigNumber = 0;
        boolean math = false;

        System.out.println("For random numbers, select 1, to define numbers press 2, to cancel press 3");
        int userInput = scan.nextInt();

        switch (userInput) {
            case 1:
                // Generate two random numbers
                math = true;
                int random1 = random.nextInt(maxRange - minRange + 1) + minRange;
                int random2 = random.nextInt(maxRange - minRange + 1) + minRange;
                System.out.println("Random number 1: " + random1);
                System.out.println("Random number 2: " + random2);

                // Calculate the sum of random numbers
                for (int i = Math.min(random1, random2); i <= Math.max(random1, random2); i++) {
                    sum += i;
                }
                if (random1 > random2) {
                    bigNumber = random1;
                    smallNumber = random2;
                } else {
                    bigNumber = random2;
                    smallNumber = random1;
                }
                break;
            case 2:
                math = true;
                System.out.println("Enter the first number: ");
                int numberOne = scan.nextInt();
                System.out.println("Enter the second number: ");
                int numberTwo = scan.nextInt();

                if (numberOne > numberTwo) {
                    bigNumber = numberOne;
                    smallNumber = numberTwo;
                } else {
                    bigNumber = numberTwo;
                    smallNumber = numberOne;
                }

                for (int i = smallNumber; i <= bigNumber; i++) {
                    sum += i;
                }
                break;
            case 3:
                System.out.println("Cancelled");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (math) {
            System.out.println("Sum of numbers between " + smallNumber + " and " + bigNumber + " is: " + sum);
        }

        scan.close();
    }
}
