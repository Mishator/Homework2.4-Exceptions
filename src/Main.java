import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) { // throws IOException, WrongLoginException, WrongPasswordException {
    //    PasswordValidator passwordValidator = new PasswordValidatorImpl();

    //    passwordValidator.validatePassword("", "", "");
    //    passwordValidator.validatePassword("AZaz09_", "AZaz09_", "AZaz09_");
    //    passwordValidator.validatePassword("User_admin", "Password_my", "Password_my");
        System.out.println(checkUser("login", "password", "password"));
    }

    public static boolean checkUser(String login, String password, String confirmPassword) {
        boolean result;
        try {
            result = checkLogin(login) && checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            result = false;
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            result = false;
        } finally {
            System.out.println("Проверка логина/пароля завершена");
        }
        return result;
        }

    public static boolean checkLogin(String login) throws Exception {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Неверный логин: " + login);
        }
        return true;
    }

    public static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^[a-z0-9_-]{1,19}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль " + password + " не подходит под требования");
        }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
            return true;
        }
}