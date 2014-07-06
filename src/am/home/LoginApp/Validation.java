package am.home.LoginApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nadya on 6/30/14.
 */
public  class Validation {

    public static boolean validateEmail(String email) {
        String emailPatternStr="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,4}";

        if(email.matches(emailPatternStr)) {
            return true;
        }

        return false;
    }

    public static boolean validatePassword(String password) {
        String passwordPatternStr = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

        if(password.matches(passwordPatternStr)) {
            return true;
        }
        return false;
    }
}
