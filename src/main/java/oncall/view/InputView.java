package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public static void inputMonthDayOfWeek() {
        String input = Console.readLine();
        InputValidator.validateMonthDayOfWeek(input);
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
