import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String validUsername = "coded";
        String validPassword = "coded123";
        
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();
                

        try {
            validateLogin(enteredUsername, enteredPassword, validPassword, validUsername);
            System.out.println("Login successful!");
                    System.out.println();


        } catch (Exception e) {

            System.out.println("error" +"  "+ "invalid credintials please try again ");

        }
            scanner.close();
    }

	private static void validateLogin(String enteredUsername, String enteredPassword, String validPassword,
			String validUsername) throws Exception {
                    if (validUsername.equals(enteredUsername) || validPassword.equals(enteredPassword)) {
                        throw new LoginException("Incorrect username or password");
	}      
} 

}
class LoginException extends Exception{
    public LoginException(String message) {
        super(message);
    }
}
