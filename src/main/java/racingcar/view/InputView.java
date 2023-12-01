package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.RacingCarName;
import racingcar.model.Utils;
import racingcar.view.dto.NamesOfRacingCarDto;

public class InputView {

    public NamesOfRacingCarDto inputCarsNamesOfCars() {
        final List<RacingCarName> racingCarNames = Utils.splitNamesOfCars(Console.readLine());
        return NamesOfRacingCarDto.from(racingCarNames);
    }

    public int inputNumberOfMoves() {
        return Utils.convertStringToInt(Console.readLine());
    }
}
