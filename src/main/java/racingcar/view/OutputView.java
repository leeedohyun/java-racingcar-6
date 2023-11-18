package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

public class OutputView {

    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBERS_OF_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printInputCarsNameMessage() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
    }

    public void printInputNumberOfMovesMessage() {
        System.out.println(INPUT_NUMBERS_OF_MOVES_MESSAGE);
    }

    public void printCurrentLocations(final List<RacingCar> movedRacingCar) {
        for (final RacingCar racingCar : movedRacingCar) {
            System.out.println(racingCar);
        }
        System.out.println();
    }

    public void printWinnerNames(final String winnerNames) {
        System.out.println(WINNER_MESSAGE + winnerNames);
    }
}
