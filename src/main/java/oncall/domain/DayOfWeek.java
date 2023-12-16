package oncall.domain;

public enum DayOfWeek {

    MON("월", 1),
    TUE("화", 2),
    WED("수", 3),
    THU("목", 4),
    FRI("금", 5),
    SAT("토", 6),
    SUN("일", 7);

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
