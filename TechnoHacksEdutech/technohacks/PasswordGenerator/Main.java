import java.security.SecureRandom;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Generator");

        // Get user input for password criteria
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUppercase = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean useDigits = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecialChars = scanner.nextLine().equalsIgnoreCase("y");

        // Generate and print the password
        String password = generatePassword(length, useUppercase, useDigits, useSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = useUppercase ? "ABCDEFGHIJKLMNOPQRSTUVWXYZ" : "";
        String digitChars = useDigits ? "0123456789" : "";
        String specialChars = useSpecialChars ? "!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~" : "";

        // Combine character sets
        String allChars = lowercaseChars + uppercaseChars + digitChars + specialChars;

        // Ensure the password length is at least 8 characters
        length = Math.max(8, length);

        // Generate the password
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
