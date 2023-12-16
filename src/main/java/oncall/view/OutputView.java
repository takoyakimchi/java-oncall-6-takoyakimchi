package oncall.view;

import java.util.List;
import oncall.domain.WorkSchedule;

public class OutputView {

    public static void printWorkSchedules(List<WorkSchedule> workSchedules) {
        for (WorkSchedule workSchedule : workSchedules) {
            int month = workSchedule.getDate().getMonth();
            int day = workSchedule.getDate().getDate();
            String dayOfWeek = workSchedule.getDate().getDayOfWeek().getName();
            String name = workSchedule.getName();

            System.out.printf("%d월 %d일 %s", month, day, dayOfWeek);
            if (workSchedule.getDate().isHoliday() && !workSchedule.getDate().isWeekend()) {
                System.out.print("(휴일)");
            }
            System.out.printf(" %s\n", name);
        }
    }
}