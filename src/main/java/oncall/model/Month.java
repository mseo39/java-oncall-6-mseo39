package oncall.model;

import oncall.view.ErrorPhrase;

import java.util.Arrays;

public enum Month {
    JANUARY(1, 1, 31),
    FEBRUARY(2, 1, 28),
    MARCH(3, 1, 31),
    APRIL(4, 1, 30),
    MAY(5, 1, 31),
    JUNE(6, 1, 30),
    JULY(7, 1, 31),
    AUGUST(8, 1, 31),
    SEPTEMBER(9, 1, 30),
    OCTOBER(10, 1, 31),
    NOVEMBER(11, 1, 30),
    DECEMBER(12, 1, 31);

    private int name;
    private int min;
    private int max;

    Month(int name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getName() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public static Month getMonth(int input){
        return Arrays.stream(Month.values())
                .filter(month -> month.name==input)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ErrorPhrase.EXIST_DAY.getPhrase()));
    }
}