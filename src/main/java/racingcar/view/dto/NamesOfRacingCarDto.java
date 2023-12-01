package racingcar.view.dto;

import java.util.List;
import racingcar.model.RacingCarName;

public record NamesOfRacingCarDto(List<RacingCarName> carNames) {

    public static NamesOfRacingCarDto from(final List<RacingCarName> carNames) {
        return new NamesOfRacingCarDto(carNames);
    }
}
