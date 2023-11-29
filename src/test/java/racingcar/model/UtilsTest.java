package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    private static final RacingCarName POBI = new RacingCarName("pobi");
    private static final RacingCarName WONI = new RacingCarName("woni");
    private static final RacingCarName JUN = new RacingCarName("jun");

    @Test
    public void 숫자가_아니면_예외_발생() {
        // given
        final String nonNumericInput = "a";

        // then
        assertThatThrownBy(() -> Utils.convertStringToInt(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자인_경우_int로_반환() {
        // given
        final String stringNumber = "1";

        // when
        final int number = Utils.convertStringToInt(stringNumber);

        // then
        Assertions.assertEquals(number, 1);
    }

    @Test
    public void 자동차_이름_분할_테스트() {
        // given
        final String namesOfCars = "pobi,woni,jun";

        // when
        final List<RacingCarName> splitNamesOfCars = Utils.splitNamesOfCars(namesOfCars);

        // then
        assertThat(splitNamesOfCars).hasSize(3)
                .contains(POBI, WONI, JUN);
    }
}