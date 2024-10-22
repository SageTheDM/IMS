// Luca Burger
// Aufgabe 12

public class App {
    public static void main(String[] args) throws Exception {
        Time myTime1 = new Time(5, 42);
        Time myTime2 = new Time(3, 27);
        Time myTime3 = new Time(5, 20);
        Time myTime4 = new Time(3, 10);
        Time myTime5 = new Time(3, 20);

        System.out.println(Time.subtract(myTime3, myTime4));
        System.out.println(Time.convertToMinute(myTime1));

    }
}
