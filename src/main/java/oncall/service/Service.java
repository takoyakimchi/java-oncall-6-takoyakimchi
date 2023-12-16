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
        String tempName = "";
        for (int i = 1; i <= lastDateOfMonth(month); i++) {
            Date date = new Date(month, i, firstDay);
            if (date.isHoliday() || date.isWeekend()) { // 휴일
                IdxNameDTO dto =
                    addToList(tempName, i, holidayIdx, holidayWorkers, workSchedules, date);
                holidayIdx = dto.getIdx();
                tempName = dto.getName();
            }
            if (!date.isHoliday() && !date.isWeekend()) { // 평일
                IdxNameDTO dto =
                    addToList(tempName, i, weekdayIdx, weekdayWorkers, workSchedules, date);
                weekdayIdx = dto.getIdx();
                tempName = dto.getName();
            }
        }
        return workSchedules;
    }

    private static IdxNameDTO addToList(String tempName, int i, int idx,
        List<String> workers, List<WorkSchedule> workSchedules, Date date) {

        int workerCount = workers.size();
        if (!tempName.isEmpty()) {
            workSchedules.add(new WorkSchedule(date, tempName));
            return new IdxNameDTO(nextIdx(idx, workerCount), "");
        }
        if (i > 1 && isSameNameAsYesterday(workSchedules, idx, workers)) {
            tempName = workers.get(idx);
            String nextName = workers.get(nextIdx(idx, workerCount));
            workSchedules.add(new WorkSchedule(date, nextName)); // 다음 이름을 add하기
            return new IdxNameDTO(nextIdx(idx, workerCount), tempName);
        }
        workSchedules.add(new WorkSchedule(date, workers.get(idx)));
        return new IdxNameDTO(nextIdx(idx, workerCount), "");
    }

    private static boolean isSameNameAsYesterday(List<WorkSchedule> workSchedules, int idx,
        List<String> workers) {

        String yesterdayName = workSchedules.get(workSchedules.size() - 1).getName();
        String todayName = workers.get(idx);

        return yesterdayName.equals(todayName);
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
