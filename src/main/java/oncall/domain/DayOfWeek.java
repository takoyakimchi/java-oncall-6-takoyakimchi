package oncall.domain;

public enum DayOfWeek {

    MON("월", 0),
    TUE("화", 1),
    WED("수", 2),
    THU("목", 3),
    FRI("금", 4),
    SAT("토", 5),
    SUN("일", 6);

    private String name;
    private int idx;

    DayOfWeek(String name, int idx) {
        this.name = name;
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public int getIdx() {
        return idx;
    }
}
