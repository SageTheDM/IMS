import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a message to encrypt:");
        String originalMessage = scanner.nextLine();

        // Encrypt the message
        System.out.println("Enter the encryption key (an integer):");
        int encryptionKey = scanner.nextInt();
        String encryptedMessage = encrypt(originalMessage, encryptionKey);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, encryptionKey);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }

    // Method to encrypt a message using Caesar cipher
    private static String encrypt(String message, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) ((currentChar - 'A' + key) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    // Method to decrypt an encrypted message using Caesar cipher
    private static String decrypt(String encryptedMessage, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);

            if (Character.isLetter(currentChar)) {
                char decryptedChar = (char) ((currentChar - 'A' - key + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }
}
