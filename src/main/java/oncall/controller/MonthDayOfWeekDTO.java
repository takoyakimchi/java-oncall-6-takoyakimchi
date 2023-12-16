package oncall.controller;

public class MonthDayOfWeekDTO {

    private int month;
    private String dayOfWeek;

    public MonthDayOfWeekDTO(String input) {
        String[] inputs = input.split(",");
        this.month = Integer.parseInt(inputs[0]);
        this.dayOfWeek = inputs[1];
    }

    public int getMonth() {
        return month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
