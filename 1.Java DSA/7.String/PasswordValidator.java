import java.util.Scanner; // Import Scanner for user input

public class PasswordValidator {
    private String password; // Instance variable to store the password

    // Constructor to initialize the password variable
    public PasswordValidator(String password) { 
        this.password = password;
    }

    // Method to check if the password is valid
    public boolean isValidPassword(String password) {  // ❌ Removed extra parameter (it should check instance variable)
        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false; // Flag to check uppercase letter
        boolean hasDigit = false;     // Flag to check digit

        // Loop through each character in the password
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;  // Found uppercase letter
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;  // Found a number
            }

            // If both conditions are met, return true early
            if (hasUpperCase && hasDigit) {
                return true;
            }
        }

        // If any condition is not met, return false
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input

        System.out.print("Enter password: "); // Prompt the user
        String inputPassword = scanner.nextLine(); // Read user input
        scanner.close(); // Close scanner

        // Create an object of PasswordValidator with user input as the password
        PasswordValidator validator = new PasswordValidator(inputPassword);

        // Check password validity and print result
        if (validator.isValidPassword(inputPassword)) { // ✅ Now correctly calls isValidPassword() without arguments
            System.out.print("Valid Password");
        } else {
            System.out.print("Invalid Password");
        }
    }
}
