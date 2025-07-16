package Validation;

import java.util.regex.Pattern;

public final class Validator {
    public boolean isValidPassword(final String password) {

        if (password == null || password.isEmpty()) return false;

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$&]).{8,}$";
        return Pattern.matches(passwordRegex, password);
    }

    public boolean isValidEmail(final String email) {

        if (email == null || email.isEmpty()) return false;

        String emailRegex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        return Pattern.matches(emailRegex, email);
    }
}
