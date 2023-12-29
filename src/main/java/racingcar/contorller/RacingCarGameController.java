package racingcar.contorller;

import racingcar.model.RacingCars;
import racingcar.model.RandomNumberGenerator;
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
        final RacingCars racingCars = RacingCars.create(inputView.inputRacingCarName());
        final int tryNumber = inputView.inputTryNumber();

        outputView.printResultMessage();
        for (int moveCount = 0; moveCount < tryNumber; moveCount++) {
            racingCars.move(new RandomNumberGenerator());
            outputView.printResult(racingCars);
        }
        outputView.printWinners(racingCars.findWinners());
    }
}
