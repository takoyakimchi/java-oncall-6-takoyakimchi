package oncall.domain;

public enum Holiday {

    NEW_YEAR_DAY(1, 1),
    MARCH_FIRST_DAY(3, 1),
    CHILDRENS_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    INDEPENDENCE_DAY(8, 15),
    NATIONAL_FOUNDATION_DAY(10, 3),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25);

    private final int month;
    private final int date;

    Holiday(int month, int date) {
        this.month = month;
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }
}
