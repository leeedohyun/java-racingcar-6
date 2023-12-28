package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RandomNumberGeneratorTest {

    @Test
    void 무작위_값_테스트() {
        // given
        final RandomNumberGenerator mock = Mockito.mock(RandomNumberGenerator.class);

        given(mock.generate())
                .willReturn(3);

        // when
        final int random = mock.generate();

        // then
        assertThat(random).isEqualTo(3);
    }
}
