package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LocationTest {

    @Test
    void 전진_테스트() {
        // given
        final Location startLocation = new Location("");

        // when
        final Location movedLocation = startLocation.goForward();

        // then
        Assertions.assertEquals(movedLocation, new Location("-"));
    }
}