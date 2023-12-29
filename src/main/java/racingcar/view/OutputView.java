package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;

public class OutputView {

    public void printWinners(final List<RacingCar> winners) {
        System.out.print("최종 우승자 : ");
        String result = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
