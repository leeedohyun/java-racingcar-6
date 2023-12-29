package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class OutputView {

    private static final String WINNER_DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final RacingCars racingCars) {
        for (RacingCar car : racingCars.getCars()) {
            System.out.print(car.getName() + " : ");
            final StringBuilder result = new StringBuilder();
            for (int i = 0; i < car.getLocation(); i++) {
                result.append("-");
            }
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(final List<RacingCar> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(concatenateWinnerNames(winners));
    }

    private String concatenateWinnerNames(final List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
