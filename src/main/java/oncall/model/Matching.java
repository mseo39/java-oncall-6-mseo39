package oncall.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matching {
    private List<String> workerMatching;
    private Month month;
    private final static List<String> days = Arrays.asList("월", "화", "수", "목", "금", "토", "일");
    private int dayStart;
    private Holiday holiday;

    public Matching(int month, String day) {
        this.month = Month.getMonth(month);
        this.workerMatching = new ArrayList<>();
        this.holiday = Holiday.getHoliday(this.month);
        this.dayStart = days.indexOf(day);
    }

    public Month getMonth() {
        return month;
    }

    public List<String> getWorkerMatching() {
        return workerMatching;
    }

    public static List<String> getDays() {
        return days;
    }

    public int getDayStart() {
        return dayStart;
    }

    public List<String> matchingLogic(Worker worker) {
        int day = this.dayStart;
        int weekdayWorker = 0;
        int weekendWorker = 0;

        for (int i = 0; i < this.month.getMax(); i++) {
            if (Day.isWeekday(days.get((i + day) % days.size()))) {
                weekdayWorker = processWeekday(worker, weekdayWorker);
            }
            if (!Day.isWeekday(days.get((i + day) % days.size())) || Holiday.getHoliday(this.month).getDays().contains(i)) {
                weekendWorker = processWeekend(worker, weekendWorker);
            }
        }
        return this.workerMatching;
    }

    private int processWeekday(Worker worker, int weekdayWorker) {
        String name = worker.getWeekday().get(weekdayWorker % worker.getWeekday().size());
        if (checkFrontWorker(name)) {
            this.workerMatching.add(name);
            weekdayWorker++;
        } else {
            weekdayWorker = updateWeekdayWorker(worker, weekdayWorker);
            this.workerMatching.clear();
            matchingLogic(worker);
        }
        return weekdayWorker;
    }

    private int processWeekend(Worker worker, int weekendWorker) {
        String name = worker.getWeekend().get(weekendWorker % worker.getWeekend().size());
        if (checkFrontWorker(name)) {
            this.workerMatching.add(name);
            weekendWorker++;
        } else {
            weekendWorker = updateWeekendWorker(worker, weekendWorker);
            this.workerMatching.clear();
            matchingLogic(worker);
        }
        return weekendWorker;
    }

    private int updateWeekdayWorker(Worker worker, int index) {
        String tmp = worker.getWeekday().get(index);
        worker.getWeekday().set(index, worker.getWeekday().get(index + 1));
        worker.getWeekday().set(index + 1, tmp);
        return index;
    }

    private int updateWeekendWorker(Worker worker, int index) {
        String tmp = worker.getWeekend().get(index);
        worker.getWeekend().set(index, worker.getWeekend().get(index + 1));
        worker.getWeekend().set(index + 1, tmp);
        return index;
    }


    public boolean checkFrontWorker(String name) {
        if (workerMatching.size() == 0) {
            return true;
        }
        if (workerMatching.get(workerMatching.size() - 1).equals(name)) {
            return false;
        }
        return true;
    }
}
