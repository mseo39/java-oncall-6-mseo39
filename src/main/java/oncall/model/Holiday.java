package oncall.model;

import oncall.view.ErrorPhrase;

import java.util.Arrays;
import java.util.List;

public enum Holiday {
    JANUARY(Month.JANUARY, Arrays.asList(1)),
    MARCH(Month.MARCH, Arrays.asList(1)),
    MAY(Month.MAY, Arrays.asList(5)),
    JUNE(Month.JUNE, Arrays.asList(6)),
    AUGUST(Month.AUGUST, Arrays.asList(15)),
    OCTOBER(Month.OCTOBER, Arrays.asList(3, 9)),
    DECEMBER(Month.DECEMBER, Arrays.asList(25));

    private Month month;
    private List<Integer> days;


    Holiday(Month month, List<Integer> days) {
        this.month = month;
        this.days = days;
    }

    public static Holiday getHoliday(Month month) {
        return Arrays.stream(Holiday.values())
                .filter(holiday -> holiday.month.equals(month))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorPhrase.EXIST_DAY.getPhrase()));
    }
}