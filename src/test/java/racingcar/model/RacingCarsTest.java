package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RacingCarsTest {

    @Test
    void 모든_자동차_전진() {
        // given
        final RacingCars racingCars = RacingCars.create(List.of("pobi", "woni"));
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);

        given(mock.generate())
                .willReturn(4);

        // when
        racingCars.move(mock);

        // then
        assertThat(racingCars.getCars()).contains(RacingCar.create("pobi", 1));
    }

    @Test
    void 모든_자동차_정지() {
        // given
        final RacingCars racingCars = RacingCars.create(List.of("pobi", "woni"));
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);

        given(mock.generate())
                .willReturn(3);

        // when
        racingCars.move(mock);

        // then
        assertThat(racingCars.getCars()).contains(RacingCar.create("pobi", 0));
    }

    @Test
    void 우승자가_1명인_경우() {
        // given
        final List<RacingCar> cars = List.of(RacingCar.create("pobi", 2), RacingCar.create("woni", 1));
        final RacingCars racingCars = new RacingCars(cars);

        // when
        final List<RacingCar> winners = racingCars.findWinners();

        // then
        assertThat(winners).hasSize(1)
                .contains(RacingCar.create("pobi", 2));
    }

    @Test
    void 우승자가_여러_명인_경우() {
        // given
        final List<RacingCar> cars = List.of(RacingCar.create("pobi", 2), RacingCar.create("woni", 2));
        final RacingCars racingCars = new RacingCars(cars);

        // when
        final List<RacingCar> winners = racingCars.findWinners();

        // then
        assertThat(winners).hasSize(2)
                .contains(RacingCar.create("pobi", 2), RacingCar.create("woni", 2));
    }
}
