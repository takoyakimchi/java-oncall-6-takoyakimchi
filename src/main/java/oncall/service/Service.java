package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import oncall.domain.WorkSchedule;

public class Service {

    public static List<WorkSchedule> assignWorkSchedule(int month, DayOfWeek firstDay,
        List<String> weekdayWorkers, List<String> holidayWorkers) {

        List<WorkSchedule> workSchedules = new ArrayList<>();
        int weekdayIdx = 0;
        int holidayIdx = 0;
        int workerCount = weekdayWorkers.size();

        for (int i = 1; i <= lastDateOfMonth(month); i++) {
            Date date = new Date(month, i, firstDay);
            if (date.isHoliday() || date.isWeekend()) {
                workSchedules.add(new WorkSchedule(date, holidayWorkers.get(holidayIdx)));
                holidayIdx = nextIdx(holidayIdx, workerCount);
            }
            if (!date.isHoliday() && !date.isWeekend()) {
                workSchedules.add(new WorkSchedule(date, weekdayWorkers.get(weekdayIdx)));
                weekdayIdx = nextIdx(weekdayIdx, workerCount);
            }
        }

        return workSchedules;
    }

    private static int nextIdx(int idx, int count) {
        int result = idx + 1;
        if (result == count) {
            result = 0;
        }
        return result;
    }

    private static int lastDateOfMonth(int month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7
            || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        return -1;
    }
}
