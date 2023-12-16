package oncall.view;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("월과 시작 요일 검증 테스트")
    void validateMonthDayOfWeek() {
        InputValidator.validateMonthDayOfWeek("12, 일");
        InputValidator.validateMonthDayOfWeek("1, 금");

        Assertions.assertThatThrownBy(() -> InputValidator.validateMonthDayOfWeek("13,월"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateMonthDayOfWeek("1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateMonthDayOfWeek("12,왈"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("평일 근무자 입력 테스트")
    void validateWeekdayWorkers() {
        InputValidator.validateWeekdayWorkers("가나다라마 , 나,다,라,마");
        InputValidator.validateWeekdayWorkers("a,b,c,d,e");

        Assertions.assertThatThrownBy(() -> InputValidator.validateWeekdayWorkers("가,가,나,다,라"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateWeekdayWorkers("가,나,다,라"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateWeekdayWorkers("가,나,다,라,1"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(
            () -> InputValidator.validateWeekdayWorkers(
                "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk,ll,mm")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("휴일 근무자 입력 테스트")
    void validateHolidayWorkers() {
        List<String> weekdayWorkers = new ArrayList<>(List.of("가","나","다","라","마"));
        InputValidator.validateHolidayWorkers(weekdayWorkers, "나,가,다,라,마");

        Assertions.assertThatThrownBy(() -> InputValidator.validateWeekdayWorkers("가,가,나,다,라"))
            .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputValidator.validateWeekdayWorkers("가,나,다,라"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}