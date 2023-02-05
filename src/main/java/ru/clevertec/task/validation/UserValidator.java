package ru.clevertec.task.validation;

import java.util.regex.Pattern;

public class UserValidator {

    private UserValidator() {

    }

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}");

    private static final Pattern USER_NAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){2,25}[a-zA-Z0-9]$");

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    private static final int MAX_PASSWORD_LENGTH = 25;

    public static boolean isUsernameValid(String username) {
        return USER_NAME_PATTERN.matcher(username).matches();
    }

    public static boolean isEmailValid(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
         return  PASSWORD_PATTERN.matcher(password).matches()
                && password.length() <= MAX_PASSWORD_LENGTH;
    }
}
