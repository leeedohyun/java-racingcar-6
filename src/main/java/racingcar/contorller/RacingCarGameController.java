package racingcar.contorller;

import java.util.List;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.model.RandomNumberGenerator;
import racingcar.util.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        final List<String> names = Utils.splitName(inputView.inputRacingCarName());
        final List<RacingCar> cars = names.stream()
                .map(RacingCar::new)
                .toList();
        final RacingCars racingCars = new RacingCars(cars);

        final int tryNumber = inputView.inputTryNumber();

        outputView.printResultMessage();
        for (int moveCount = 0; moveCount < tryNumber; moveCount++) {
            racingCars.move(new RandomNumberGenerator());
            outputView.printResult(racingCars);
        }
        outputView.printWinners(racingCars.findWinners());
    }
}
