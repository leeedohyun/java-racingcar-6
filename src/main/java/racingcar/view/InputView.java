package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Utils;

public class InputView {

    public String inputCarsNamesOfCars() {
        return Console.readLine();
    }

    public int inputNumberOfMoves() {
        return Utils.convertStringToInt(Console.readLine());
    }
}
