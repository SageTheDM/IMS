public class App {
    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number = number / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversed = reverse(number);
        System.out.println("The number is: " + number);
        System.out.println("The reversed number is: " + reversed);
    }
}
