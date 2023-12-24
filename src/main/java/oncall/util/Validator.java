package oncall.util;

import oncall.model.Matching;
import oncall.view.ErrorPhrase;

public class Validator {
    public static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorPhrase.STRING_TO_INTEGER.getPhrase());
        }
    }

    public static String validateDay(String day){
        if(!Matching.getDays().contains(day)){
            throw new IllegalArgumentException(ErrorPhrase.EXIST_DAY.getPhrase());
        }
        return day;
    }
}
