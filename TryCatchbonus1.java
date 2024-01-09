import java.util.Scanner;

public class TryCatchbonus1 {
    public static void main(String[] args) {
        String correctUsername = "coded";
        String correctPassword = "coded123";

        Scanner scanner = new Scanner(System.in);

        boolean loginSuccessful = false;

        while (!loginSuccessful) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            try {
                validateLogin(enteredUsername, enteredPassword, correctUsername, correctPassword);
                System.out.println("Login successful!");
                loginSuccessful = true; // Set the flag to exit the loop
            } catch (LoginException e) {
                System.out.println("Login failed: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }

    private static void validateLogin(String enteredUsername, String enteredPassword,
                                      String correctUsername, String correctPassword) throws LoginException {
        if (!correctUsername.equals(enteredUsername) || !correctPassword.equals(enteredPassword)) {
            throw new LoginException("Incorrect username or password");
        }
    }
}

// Custom exception class for handling login exceptions
class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}