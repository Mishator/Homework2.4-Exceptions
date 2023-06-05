import java.io.IOException;

public interface PasswordValidator {
    boolean validatePassword(String login, String password, String confirmPassword) throws IOException, WrongLoginException, WrongPasswordException;
}
