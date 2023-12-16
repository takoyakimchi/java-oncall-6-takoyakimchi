package oncall.controller;

import java.util.List;

public class WorkersDTO {

    private final List<String> weekdayWorkers;
    private final List<String> holidayWorkers;

    public WorkersDTO(List<String> weekdayWorkers, List<String> holidayWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.holidayWorkers = holidayWorkers;
    }

    public List<String> getWeekdayWorkers() {
        return weekdayWorkers;
    }

    public List<String> getHolidayWorkers() {
        return holidayWorkers;
    }
}
