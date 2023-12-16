package oncall.model;

import oncall.view.ErrorPhrase;

import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private List<String> weekday;
    private List<String> weekend;

    public Worker(List<String> weekday, List<String> weekend) {
        nameLength(weekday);
        nameLength(weekend);
        validateWorkerNum(weekday);
        validateWorkerNum(weekend);
        validateNameDuplicate(weekday);
        validateNameDuplicate(weekend);
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

    public static void validateWorkerNum(List<String> worker) {
        if (worker.size() >= 5 && worker.size() <= 35) {
            throw new IllegalArgumentException(ErrorPhrase.WORKER_LENGTH.getPhrase());
        }
    }

    public static void validateNameDuplicate(List<String> worker){
        if(worker.size()!=worker.stream().distinct().collect(Collectors.toList()).size()){
            throw new IllegalArgumentException(ErrorPhrase.NAME_DUPLACATE.getPhrase());
        }
    }
}
