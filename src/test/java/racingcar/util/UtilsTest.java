package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilsTest {

    @Test
    void 콤마를_기준으로_이름을_구분한다() {
        // given
        final String name = "pobi,woni,jun";

        // when
        final List<String> names = Utils.splitName(name);

        // then
        assertThat(names).hasSize(3)
                .contains("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "fd", "1$"})
    void 시도_횟수가_숫자가_아니면_예외_발생(final String tryNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Utils.convertInt(tryNumber));
    }
}
