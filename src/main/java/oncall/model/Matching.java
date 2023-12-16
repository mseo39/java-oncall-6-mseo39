package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SimpleTimeZone;

public class Matching {
    private List<String> workerMatching;
    private Month month;
    private final static List<String> days = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
    private Holiday holiday;

    public Matching(int month) {
        this.month = Month.getMonth(month);
        this.workerMatching = new ArrayList<>();
        this.holiday = Holiday.getHoliday(this.month);
    }

    public boolean checkFrontWorker(String name){
        if(workerMatching.get(workerMatching.size()-1).equals(name)){
            return false;
        }
        return true;
    }
}
