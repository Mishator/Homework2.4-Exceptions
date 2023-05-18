import java.io.IOException;

public class PasswordValidatorTest {
    public static void main(String[] args) throws IOException, WrongLoginException, WrongPasswordException {
        PasswordValidator passwordValidator = new PasswordValidatorImpl();

        passwordValidator.validatePassword("", "", "");
        passwordValidator.validatePassword("AZaz09_", "AZaz09_", "AZaz09_");
        passwordValidator.validatePassword("User_admin", "Password_my", "Password_my");
    }
}
