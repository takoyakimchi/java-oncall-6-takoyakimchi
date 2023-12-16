package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.controller.MonthDayOfWeekDTO;
import oncall.controller.WorkersDTO;

public class InputView {

    public static MonthDayOfWeekDTO inputMonthDayOfWeek() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String input = Console.readLine();
        InputValidator.validateMonthDayOfWeek(input);
        return new MonthDayOfWeekDTO(input);
    }

    public static WorkersDTO inputWorkers() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String weekdayInput = Console.readLine();
        System.out.print("주말 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String holidayInput = Console.readLine();

        InputValidator.validateWeekdayWorkers(weekdayInput);
        List<String> weekdayWorkers = InputBuilder.buildWorkerList(weekdayInput);
        InputValidator.validateHolidayWorkers(weekdayWorkers, holidayInput);
        List<String> holidayWorkers = InputBuilder.buildWorkerList(holidayInput);

        return new WorkersDTO(weekdayWorkers, holidayWorkers);
    }
}
