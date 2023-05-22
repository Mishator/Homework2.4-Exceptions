public class PasswordValidatorImpl implements PasswordValidator {
    String regex = "[A-Za-z0-9_]*";
    int lengthMax = 19;

    @Override
    public boolean validatePassword(String login, String password, String confirmPassword) {
        boolean result = false;
        if (!login.matches(regex)) {
            try {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        } else if (login.length() >= lengthMax) {
            try {
                throw new WrongLoginException("Логин слишком длинный");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }

        } else if (!password.matches(regex) || !confirmPassword.matches(regex)) {
            try {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        } else if (password.length() >= lengthMax || confirmPassword.length() >= lengthMax) {
            try {
                throw new WrongPasswordException("Пароль слишком длинный");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }

        } else if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }

        } else {
            result = true;
            printResult(login, password, confirmPassword, result);
        }

        return result;
    }

    private void printResult(String login, String password, String confirmPassword, boolean result) {
        System.out.println("This set: ");
        System.out.println(
                login + " -> login ok\n"
                        + password + " -> password ok\n"
                        + confirmPassword + " -> confirmPassword ok"
        );

        if (result) {
            System.out.println(result + " -> passwords are equal\n");
        } else {
            System.out.println(result + " -> passwords are not equal\n");
        }
    }
}



