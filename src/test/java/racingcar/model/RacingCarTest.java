package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"poobi", "woooni", "juuuun"})
    void 자동차의_이름이_4자를_초과하면_예외_발생(final String carName) {
        assertThatThrownBy(() -> createWithName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8})
    void 무작위_값이_4_이상인_경우_전진(final int random) {
        // given
        final RacingCar racingCar = createWithName("pobi");

        // when
        racingCar.move(random);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 무작위_값이_4_미만인_경우_정지(final int random) {
        // given
        final RacingCar racingCar = createWithName("pobi");

        // when
        racingCar.move(random);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(0);
    }

    private RacingCar createWithName(final String name) {
        return RacingCar.create(name, 0);
    }
}
