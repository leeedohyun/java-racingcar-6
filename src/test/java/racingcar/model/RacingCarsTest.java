package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private final RacingCarName POBI = new RacingCarName("pobi");
    private final RacingCarName WONI = new RacingCarName("woni");
    private final RacingCarName ANOTHER_POBI = new RacingCarName("pobi");

    @Test
    public void 이름_중복_테스트() {
        // given
        final List<RacingCarName> namesOfCars = List.of(POBI, WONI, ANOTHER_POBI);

        // then
        Assertions.assertThatThrownBy(() -> RacingCars.create(namesOfCars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}