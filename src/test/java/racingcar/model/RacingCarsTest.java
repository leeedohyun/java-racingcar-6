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
        final RacingCars racingCars = new RacingCars(List.of(new RacingCar("pobi"), new RacingCar("woni")));
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);

        given(mock.generate())
                .willReturn(4);

        // when
        racingCars.move(mock);

        // then
        assertThat(racingCars.getCars()).contains(new RacingCar("pobi", 1));
    }

    @Test
    void 모든_자동차_정지() {
        // given
        final RacingCars racingCars = new RacingCars(List.of(new RacingCar("pobi"), new RacingCar("woni")));
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);

        given(mock.generate())
                .willReturn(3);

        // when
        racingCars.move(mock);

        // then
        assertThat(racingCars.getCars()).contains(new RacingCar("pobi", 0));
    }
}
