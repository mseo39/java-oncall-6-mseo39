package oncall.model;

import oncall.view.ErrorPhrase;

import java.util.List;

public class Worker {
    private List<String> weekday;
    private List<String> weekend;

    public Worker(List<String> weekday, List<String> weekend) {
        this.weekday = weekday;
        this.weekend = weekend;
    }

    public static void nameLength(List<String> worker) {
        for (String name : worker) {
            if (name.length() > 5 || name.length() < 1) {
                throw new IllegalArgumentException(ErrorPhrase.NAME_LENGTH.getPhrase());
            }
        }
    }
}
