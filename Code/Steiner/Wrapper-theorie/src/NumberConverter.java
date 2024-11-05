import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        String input = scanner.nextLine();

        // Convert input to an Integer object
        Integer number = Integer.valueOf(input);

        // A1) Display the entered number
        System.out.println("A1) Entered number: " + number.toString());

        // A2) Convert to binary and display
        String binaryString = Integer.toBinaryString(number);
        System.out.println("A2) Number in binary: " + binaryString);

        // A3) Convert to hexadecimal and display
        String hexString = Integer.toHexString(number);
        System.out.println("A3) Number in hexadecimal: " + hexString);

        // A4) Display the maximum value for Integer
        System.out.println("A4) Maximum value of Integer: " + Integer.MAX_VALUE);

        // A5) Display the minimum value for Integer
        System.out.println("A5) Minimum value of Integer: " + Integer.MIN_VALUE);

        // B1) Convert the binary string back to decimal and display
        Integer fromBinary = Integer.valueOf(binaryString, 2);
        System.out.println("B1) Converted back from binary: " + fromBinary.toString());

        // B2) Convert the hexadecimal string back to decimal and display
        Integer fromHex = Integer.valueOf(hexString, 16);
        System.out.println("B2) Converted back from hexadecimal: " + fromHex.toString());

        // Close the scanner
        scanner.close();
    }
}
