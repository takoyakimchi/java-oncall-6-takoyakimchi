package oncall.controller;

import java.util.List;
import oncall.domain.DayOfWeek;
import oncall.domain.WorkSchedule;
import oncall.service.Service;
import oncall.view.InputView;
import oncall.view.IterativeReader;
import oncall.view.OutputView;

public class Controller {

    public static void start() {
        MonthDayOfWeekDTO monthDayOfWeek = IterativeReader.read(InputView::inputMonthDayOfWeek);
        int month = monthDayOfWeek.getMonth();
        DayOfWeek firstDay = monthDayOfWeek.getDayOfWeek();

        WorkersDTO workers = IterativeReader.read(InputView::inputWorkers);
        List<String> weekdayWorkers = workers.getWeekdayWorkers();
        List<String> holidayWorkers = workers.getHolidayWorkers();

        List<WorkSchedule> workSchedules = Service.assignWorkSchedule(
            month, firstDay, weekdayWorkers, holidayWorkers);

        OutputView.printWorkSchedules(workSchedules);
    }
}
