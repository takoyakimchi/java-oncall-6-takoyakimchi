package oncall.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static void validateMonthDayOfWeek(String input) {
        String[] inputs = input.split("\\s*,\\s*");

        if (inputs.length != 2) {
            throw new IllegalArgumentException("올바른 월과 시작 요일을 입력하세요.");
        }

        validateMonth(inputs[0]);
        validateDayOfWeek(inputs[1]);
    }

    public static void validateWeekdayWorkers(String input) {
        String[] inputs = input.split("\\s*,\\s*");
        validateWorkerCount(inputs);
        validateNameRule(inputs);
    }

    public static void validateHolidayWorkers(List<String> weekdayWorkers, String input) {
        String[] inputs = input.split("\\s*,\\s*");
        List<String> holidayWorkers = Arrays.asList(inputs);

        Set<String> weekdaySet = new HashSet<>(weekdayWorkers);
        Set<String> holidaySet = new HashSet<>(holidayWorkers);

        if (!weekdaySet.equals(holidaySet)) {
            throw new IllegalArgumentException("모든 근무자는 평일 1회, 휴일 1회 근무해야 합니다.");
        }
    }

    private static void validateWorkerCount(String[] inputs) {
        if (inputs.length < 5 || inputs.length > 35) {
            throw new IllegalArgumentException("5명 이상 35명 이하의 근무자를 입력해 주세요.");
        }
    }

    private static void validateNameRule(String[] inputs) {
        List<String> workers = new ArrayList<>();
        for (String name : inputs) {
            // 이름 5글자 이하 검증
            if (!name.matches("[가-힣a-zA-Z]{1,5}")) {
                throw new IllegalArgumentException("1~5자의 한글 혹은 영문 이름만 허용합니다.");
            }
            // 이름 중복 검증
            if (workers.contains(name)) {
                throw new IllegalArgumentException("평일 혹은 휴일에만 2회 이상 근무할 수 없습니다.");
            }
            workers.add(name);
        }
    }

    private static void validateMonth(String input) {
        int month;

        // 정수 검증
        try {
            month = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 월을 입력하세요.");
        }

        // 범위 검증
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("1월부터 12월까지 입력하세요.");
        }
    }

    private static void validateDayOfWeek(String input) {
        List<String> validDays = new ArrayList<>(List.of("월", "화", "수", "목", "금", "토", "일"));
        if (!validDays.contains(input)) {
            throw new IllegalArgumentException("올바른 요일을 입력하세요.");
        }
    }
}
