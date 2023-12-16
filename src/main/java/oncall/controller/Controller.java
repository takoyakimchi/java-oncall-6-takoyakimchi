package oncall.controller;

import java.util.List;
import oncall.domain.DayOfWeek;
import oncall.domain.WorkSchedule;
import oncall.service.Service;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {

    public static void start() {
        OutputView.printMonthDayOfWeek();
        MonthDayOfWeekDTO monthDayOfWeek = InputView.inputMonthDayOfWeek();
        int month = monthDayOfWeek.getMonth();
        DayOfWeek firstDay = monthDayOfWeek.getDayOfWeek();

        OutputView.printWeekdayWorkers();
        List<String> weekdayWorkers = InputView.inputWeekdayWorkers();

        OutputView.printHolidayWorkers();
        List<String> holidayWorkers = InputView.inputHolidayWorkers(weekdayWorkers);

        List<WorkSchedule> workSchedules = Service.assignWorkSchedule(
            month, firstDay, weekdayWorkers, holidayWorkers);

        OutputView.printWorkSchedules(workSchedules);
    }
}
