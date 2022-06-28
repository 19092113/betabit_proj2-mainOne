package nl.betabit.betabit;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {

    public boolean isFullName(String name) {
        String regx = "^[a-zA-Z_ ]*$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find() && name.length() > 2 && name.contains(" ");
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean alreadyRegistered(String username) {

        for (User user : Data.getUser()) {
            if (username.equals(user.getMail())) {
                return true;
            }
        }
        return false;
    }

    public static String getDate() {

        LocalDate today = LocalDate.now();
        return String.valueOf(today);
    }

}
