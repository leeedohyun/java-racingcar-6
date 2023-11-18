package racingcar.controller;

import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarFactory;
import racingcar.model.RacingCars;
import racingcar.model.Name;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void playRacingCarGame() {
        OutputView.printInputCarsNameMessage();

        final List<Name> namesOfCars = Utils.splitNamesOfCars(InputView.inputCarsNamesOfCars());
        final List<RacingCar> racingCarList = RacingCarFactory.generateCar(namesOfCars);
        final RacingCars racingCars = new RacingCars(racingCarList);

        OutputView.printInputNumberOfMovesMessage();
        final int numberOfMoves = InputView.inputNumberOfMoves();

        for (int moveCount = 0; moveCount < numberOfMoves; moveCount++) {
            final List<RacingCar> movedRacingCars = racingCars.move(randomNumberGenerator);
            OutputView.printCurrentLocations(movedRacingCars);
        }

        final String winnerNamesOfCars = racingCars.findWinners();

        OutputView.printWinnerNames(winnerNamesOfCars);
    }
}
