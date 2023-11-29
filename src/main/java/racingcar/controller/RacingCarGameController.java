package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCarName;
import racingcar.model.RacingCars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        randomNumberGenerator = new RandomNumberGenerator();
    }

    public void playRacingCarGame() {
        outputView.printInputCarsNameMessage();

        final List<RacingCarName> namesOfCars = Utils.splitNamesOfCars(inputView.inputCarsNamesOfCars());
        RacingCars racingCars = RacingCars.create(namesOfCars);

        outputView.printInputNumberOfMovesMessage();
        final int numberOfMoves = inputView.inputNumberOfMoves();

        for (int moveCount = 0; moveCount < numberOfMoves; moveCount++) {
            racingCars = racingCars.move(randomNumberGenerator);
            outputView.printCurrentLocations(racingCars);
        }

        final String winnerNamesOfCars = racingCars.findWinners();

        outputView.printWinnerNames(winnerNamesOfCars);
    }
}
