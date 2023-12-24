package oncall.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static List<String> readMonth() {
        System.out.print(InputPhrase.INPUT_MONTH.getPhrase());
        return Arrays.stream(readLine().split(",")).toList();
    }

    public static List<String> readWeekdayWorker() {
        System.out.print(InputPhrase.WEEKDAY_WORKER.getPhrase());
        return Arrays.stream(readLine().split(",")).toList();
    }

    public static List<String> readWeekendWorker() {
        System.out.print(InputPhrase.WEEKEND_WORKER.getPhrase());
        return Arrays.stream(readLine().split(",")).toList();
    }
}