package oncall.model;

import java.util.Arrays;
import java.util.List;

public enum Day {
    WEEKDAY("평일", Arrays.asList("월", "화", "수", "목", "금")),
    WEEKEND("휴일", Arrays.asList("토", "일"));

    private String type;
    private List<String> days;

    Day(String type, List<String> days) {
        this.type = type;
        this.days = days;
    }

    public static boolean isWeekday(String input){
        if(WEEKDAY.days.contains(input)){
            return true;
        }
        return false;
    }

    public static boolean isWeekend(String input){
        if(WEEKEND.days.contains(input)){
            return true;
        }
        return false;
    }
}
