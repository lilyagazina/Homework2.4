import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        System.out.println(check(login, password, confirmPassword));
        System.out.println();
    }

    public static boolean contains(String str) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+]*");
        Matcher matcher = pattern.matcher(str);
        return !!matcher.matches();
    }

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Логин введен некорректно ");
            }

            boolean a = contains(login);
            if (!a) {
                throw new WrongLoginException("Логин введен некорректно ");
            }

            if (password.length() >= 20) {
                throw new WrongPasswordException("Пароль введен некорректно ");
            }

            boolean b = contains(password);
            if (!b) {
                throw new WrongLoginException("Пароль введен некорректно ");
            }

            if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают. ");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
