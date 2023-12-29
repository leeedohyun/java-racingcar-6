package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;

public class OutputView {

    private static final String WINNER_DELIMITER = ", ";

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
