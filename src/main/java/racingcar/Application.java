package racingcar;

import racingcar.contorller.RacingCarGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new RacingCarGameController(new InputView(), new OutputView()).play();
    }
}
