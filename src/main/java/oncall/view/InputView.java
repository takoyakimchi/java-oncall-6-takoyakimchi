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

    public static List<String> inputWeekdayWorkers() {
        String input = Console.readLine();
        InputValidator.validateWeekdayWorkers(input);
        return InputBuilder.buildWorkerList(input);
    }

    public static List<String> inputHolidayWorkers(List<String> weekdayWorkers) {
        String input = Console.readLine();
        InputValidator.validateHolidayWorkers(weekdayWorkers, input);
        return InputBuilder.buildWorkerList(input);
    }
}
