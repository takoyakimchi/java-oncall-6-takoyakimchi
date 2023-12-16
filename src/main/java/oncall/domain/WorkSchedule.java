package oncall.domain;

public class WorkSchedule {
    private Date date;
    private String name;

    public WorkSchedule(Date date, String name) {
        this.date = date;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
