import java.util.Scanner;

public class TryCatchbonus2 {

    public static void main(String[] args) {
        String correctUsername = "coded";
        String correctPassword = "coded123";

        Scanner scanner = new Scanner(System.in);

        boolean loginSuccessful = false;

        for (int attempt = 1; attempt <= 5; attempt++) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            try {
                validateLogin(enteredUsername, enteredPassword, correctUsername, correctPassword);
                System.out.println("Login successful!");
                loginSuccessful = true; 
                break; 
            } catch (LoginException e) {
                System.out.println("Login failed: " + e.getMessage());
                System.out.println("Please try again. Attempts remaining: " + (5 - attempt));
            }
        }

        if (!loginSuccessful) {
            System.out.println("Maximum attempts exceeded. Exiting program.");
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

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}





