package oncall.controller;

import java.util.List;

public class WorkersDTO {

    private List<String> weekdayWorkers;
    private List<String> holidayWorkers;

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
