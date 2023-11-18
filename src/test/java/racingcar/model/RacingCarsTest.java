package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    private final Name POBI = new Name("pobi");
    private final Name WONI = new Name("woni");
    private final Name ANOTHER_POBI = new Name("pobi");

    @Test
    public void 이름_중복_테스트() {
        // given
        final List<RacingCar> racingCars = List.of(new RacingCar(POBI), new RacingCar(WONI), new RacingCar(ANOTHER_POBI));

        // then
        Assertions.assertThatThrownBy(() -> new RacingCars(racingCars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}