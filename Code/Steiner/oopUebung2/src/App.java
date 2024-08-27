public class App {

    public static void main(String[] args) {
        // Define vehicles as a 2D array of objects
        Object[][] vehicles = {
                { "Tesla", "Model S", 79999, "USD", 4, 19, 2.1 },
                { "BMW", "i8", 147500, "USD", 4, 20, 1.8 },
                { "Ducati", "Panigale V4", 21995, "USD", 2, 17, 3.2 },
                { "Ford", "Mustang GT", 55995, "USD", 4, 20, 2.5 },
                { "Audi", "A4", 39900, "USD", 4, 18, 2.0 },
                { "Harley-Davidson", "Street 750", 7499, "USD", 2, 17, 2.5 },
                { "Mercedes-Benz", "S-Class", 109900, "USD", 4, 19, 2.3 },
                { "Honda", "Civic Type R", 37995, "USD", 4, 20, 2.2 },
                { "Kawasaki", "Ninja ZX-10R", 16799, "USD", 2, 17, 2.8 },
                { "Chevrolet", "Corvette Stingray", 65995, "USD", 4, 20, 2.6 },
                { "Porsche", "911 Carrera", 99900, "USD", 4, 20, 2.4 },
                { "Toyota", "Land Cruiser", 85995, "USD", 4, 18, 2.7 },
                { "BMW", "M3", 71900, "USD", 4, 19, 2.1 },
                { "Harley-Davidson", "XLH Sportster 1200", 9995, "USD", 2, 16, 2.8 }
        };

        // Create an array to hold Car objects
        Car[] myCars = new Car[vehicles.length];

        // Create and store Car objects in the array
        for (int i = 0; i < vehicles.length; i++) {
            myCars[i] = createCar(vehicles[i]);
        }

        // Print out the details of each Car
        for (Car car : myCars) {
            printCar(car);
        }
    }

    private static Car createCar(Object[] vehicle) {
        Car car = new Car();
        car.brand = (String) vehicle[0];
        car.name = (String) vehicle[1];
        car.price.price = (int) vehicle[2];
        car.price.currency = (String) vehicle[3];
        car.wheel.numberOfWheels = (int) vehicle[4];
        car.wheel.zoll = (int) vehicle[5];
        car.wheel.bar = (double) vehicle[6];
        return car;
    }

    private static void printCar(Car car) {
        System.out.println("Brand: " + car.brand);
        System.out.println("Name: " + car.name);
        System.out.println("Price: " + car.price.price + " " + car.price.currency);
        System.out.println("Wheels: " + car.wheel.numberOfWheels);
        System.out.println("Zoll: " + car.wheel.zoll);
        System.out.println("Bar: " + car.wheel.bar);
        System.out.println("");
    }
}
