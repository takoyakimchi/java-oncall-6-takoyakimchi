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
        String tempName = "";

        for (int i = 1; i <= lastDateOfMonth(month); i++) {
            Date date = new Date(month, i, firstDay);
            if (date.isHoliday() || date.isWeekend()) { // 휴일
                // 임시 저장 이름이 존재하는 경우
                if (!tempName.isEmpty()) {
                    workSchedules.add(new WorkSchedule(date, tempName));
                    tempName = "";
                    holidayIdx = nextIdx(holidayIdx, workerCount);
                    continue;
                }
                // 어제와 오늘의 이름이 겹치는 경우
                if (i > 1 && isSameNameAsYesterday(workSchedules, holidayIdx, holidayWorkers)) {
                    tempName = holidayWorkers.get(holidayIdx);
                    String nextName = holidayWorkers.get(nextIdx(holidayIdx, workerCount));
                    workSchedules.add(new WorkSchedule(date, nextName)); // 다음 이름을 add하기
                    holidayIdx = nextIdx(holidayIdx, workerCount);
                    continue;
                }
                // 그 밖의 경우
                workSchedules.add(new WorkSchedule(date, holidayWorkers.get(holidayIdx)));
                holidayIdx = nextIdx(holidayIdx, workerCount);
            }
            if (!date.isHoliday() && !date.isWeekend()) { // 평일
                // 임시 저장 이름이 존재하는 경우
                if (!tempName.isEmpty()) {
                    workSchedules.add(new WorkSchedule(date, tempName));
                    tempName = "";
                    weekdayIdx = nextIdx(weekdayIdx, workerCount);
                    continue;
                }
                // 어제와 오늘의 이름이 겹치는 경우
                if (i > 1 && isSameNameAsYesterday(workSchedules, weekdayIdx, weekdayWorkers)) {
                    tempName = weekdayWorkers.get(weekdayIdx);
                    String nextName = weekdayWorkers.get(nextIdx(weekdayIdx, workerCount));
                    workSchedules.add(new WorkSchedule(date, nextName)); // 다음 이름을 add하기
                    weekdayIdx = nextIdx(weekdayIdx, workerCount);
                    continue;
                }
                // 그 밖의 경우
                workSchedules.add(new WorkSchedule(date, weekdayWorkers.get(weekdayIdx)));
                weekdayIdx = nextIdx(weekdayIdx, workerCount);
            }
        }

        return workSchedules;
    }

    private static boolean isSameNameAsYesterday(List<WorkSchedule> workSchedules, int idx,
        List<String> workers) {

        String yesterdayName = workSchedules.get(workSchedules.size() - 1).getName();
        String todayName = workers.get(idx);

        return yesterdayName.equals(todayName);
    }

    private static int addToListAndGetNextIndex(List<WorkSchedule> workSchedules, int idx,
        List<String> workers) {
        // 마지막과 이름이 동일한 경우
        String yesterdayName = workSchedules.get(workSchedules.size() - 1).getName();
        String todayName = workers.get(idx);
        if (yesterdayName.equals(todayName)) {

        }

        return 0;
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
