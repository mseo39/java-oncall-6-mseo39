package oncall.util;

import oncall.view.ErrorPhrase;

public class Validator {
    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorPhrase.STRING_TO_INTEGER.getPhrase());
        }
    }
}
