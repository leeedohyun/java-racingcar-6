package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.dto.WinnersDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.dto.NamesOfRacingCarDto;

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

        final NamesOfRacingCarDto namesOfRacingCarDto = inputView.inputCarsNamesOfCars();
        RacingCars racingCars = RacingCars.create(namesOfRacingCarDto.carNames());

        outputView.printInputNumberOfMovesMessage();
        final int numberOfMoves = inputView.inputNumberOfMoves();

        for (int moveCount = 0; moveCount < numberOfMoves; moveCount++) {
            racingCars = racingCars.move(randomNumberGenerator);
            outputView.printCurrentLocations(racingCars);
        }

        final WinnersDto winnersDto = racingCars.findWinners();

        outputView.printWinnerNames(winnersDto);
    }
}
