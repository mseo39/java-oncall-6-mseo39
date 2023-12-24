package oncall.view;

import oncall.model.Holiday;
import oncall.model.Matching;

import java.util.List;

public class OutputView {
    public static void printMatching(Matching matching) {
        int dayStart = matching.getDayStart();
        List<String> day = matching.getDays();
        for(int i=0; i<matching.getWorkerMatching().size(); i++){
            System.out.print(matching.getMonth().getName()+"월 ");
            System.out.print((i+1)+"일 ");
            System.out.print(day.get(dayStart%day.size()));
            if(Holiday.getHoliday(matching.getMonth()).getDays().contains(i+1)){
                System.out.print("(휴일)");
            }
            System.out.println(" "+matching.getWorkerMatching().get(i));
            dayStart++;
        }
    }

}