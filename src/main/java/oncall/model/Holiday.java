package oncall.model;

import java.util.Arrays;
import java.util.List;

public enum Holiday {
    JANUARY(Month.JANUARY, Arrays.asList(1)),
    MARCH(Month.MARCH, Arrays.asList(1)),
    MAY(Month.MAY, Arrays.asList(5)),
    JUNE(Month.JUNE, Arrays.asList(6)),
    AUGUST(Month.AUGUST, Arrays.asList(15)),
    OCTOBER(Month.OCTOBER, Arrays.asList(3, 9)),
    DECEMBER(Month.DECEMBER, Arrays.asList(25)),
    NOT(Month.OCTOBER, Arrays.asList(0));

    private Month month;
    private List<Integer> days;


    Holiday(Month month, List<Integer> days) {
        this.month = month;
        this.days = days;
    }

    public List<Integer> getDays() {
        return days;
    }

    public static Holiday getHoliday(Month month) {
        return Arrays.stream(Holiday.values())
                .filter(holiday -> holiday.month.equals(month))
                .findFirst()
                .orElse(NOT);
    }
}