package by.tms.password.module;

public class Autorization {

    public static void checkAuthorization(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (Autorization.WrongLoginException ex) {
            System.out.println(ex.getMessage());
        } catch (Autorization.WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkLogin(String login) throws WrongLoginException {
        if (login.matches("^[a-zA-Z0-9_]{0,20}$")) {
            System.out.println("Логин принят");
        } else {
            throw new WrongLoginException("Логин не соответствует критериям");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.matches("^[a-zA-Z0-9_]{0,20}$") && password.equals(confirmPassword)) {
            System.out.println("Пароль принят");
        } else {
            throw new WrongPasswordException("Пароль не соответствуем критериям");
        }
    }


    public static class WrongLoginException extends Exception {
        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }

    public static class WrongPasswordException extends Exception {
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }
}
