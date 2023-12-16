package oncall.domain;

public class Date {

    private final int month;
    private final int date;
    private final DayOfWeek dayOfWeek;

    public Date(int month, int date, DayOfWeek firstDay) {
        this.month = month;
        this.date = date;
        this.dayOfWeek = calculateDayOfWeek(date, firstDay);
    }

    private static DayOfWeek calculateDayOfWeek(int date, DayOfWeek firstDay) {
        int idxDiff = firstDay.getIdx() - 1;
        int idx = (date + idxDiff) % 7;

        DayOfWeek result = null;
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (idx == dayOfWeek.getIdx()) {
                result = dayOfWeek;
            }
        }
        return result;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isHoliday() {
        // 주말
        if (this.dayOfWeek == DayOfWeek.SAT || this.dayOfWeek == DayOfWeek.SUN) {
            return true;
        }
        // 법정공휴일
        for (Holiday holiday : Holiday.values()) {
            if ((holiday.getMonth() == this.month) && (holiday.getDate() == this.date)) {
                return true;
            }
        }
        return false;
    }
}
