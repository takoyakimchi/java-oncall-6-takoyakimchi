package oncall.view;

import java.util.List;
import oncall.domain.WorkSchedule;

public class OutputView {

    public static void printMonthDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public static void printWeekdayWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public static void printHolidayWorkers() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

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