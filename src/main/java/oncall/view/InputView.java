package oncall.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static List<String> readMonth() {
        System.out.print(InputPhrase.INPUT_MONTH.getPhrase()+" ");
        return Arrays.stream(readLine().split(",")).toList();
    }
}