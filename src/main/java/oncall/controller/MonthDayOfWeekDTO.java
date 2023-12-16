package oncall.controller;

import oncall.domain.DayOfWeek;

public class MonthDayOfWeekDTO {

    private int month;
    private DayOfWeek dayOfWeek;

    public MonthDayOfWeekDTO(String input) {
        String[] inputs = input.split(",");
        this.month = Integer.parseInt(inputs[0]);
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek.getName().equals(inputs[1])) {
                this.dayOfWeek = dayOfWeek;
            }
        }
    }

    public int getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
