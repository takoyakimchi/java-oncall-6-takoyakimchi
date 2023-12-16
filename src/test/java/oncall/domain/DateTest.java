package oncall.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    @DisplayName("5/1이 일요일일 때 5/9는 월요일")
    void newDate() {
        Date date1 = new Date(5, 9, DayOfWeek.SUN);
        DayOfWeek dayOfWeek = date1.getDayOfWeek();
        Assertions.assertThat(dayOfWeek).isEqualTo(DayOfWeek.MON);
    }
}