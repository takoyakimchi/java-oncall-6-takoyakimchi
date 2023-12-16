package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.controller.MonthDayOfWeekDTO;

public class InputView {

    public static MonthDayOfWeekDTO inputMonthDayOfWeek() {
        String input = Console.readLine();
        InputValidator.validateMonthDayOfWeek(input);
        return new MonthDayOfWeekDTO(input);
    }

    public static void inputWeekdayWorkers() {
        String input = Console.readLine();
        InputValidator.validateWeekdayWorkers(input);
    }

    public static void inputHolidayWorkers(List<String> weekdayWorkers) {
        String input = Console.readLine();
        InputValidator.validateHolidayWorkers(weekdayWorkers, input);
    }
}
