package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

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
}
