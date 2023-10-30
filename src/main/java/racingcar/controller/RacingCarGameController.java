package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private Cars cars;

    public void playRacingCarGame() {
        OutputView.printInputCarsNameMessage();

        List<Name> namesOfCars = Utils.splitNamesOfCars(InputView.inputCarsNamesOfCars());
        List<Car> carList = CarFactory.generateCar(namesOfCars);
        cars = new Cars(carList);

        OutputView.printInputNumberOfMovesMessage();
        int numberOfMoves = InputView.inputNumberOfMoves();

        for (int i = 0; i < numberOfMoves; i++) {
            List<Car> movedCars = cars.moveCars(randomNumberGenerator);
            OutputView.printCurrentLocations(movedCars);
        }

        String winnerNamesOfCars = cars.findWinnerCars();

        OutputView.printWinnerNames(winnerNamesOfCars);
    }
}
