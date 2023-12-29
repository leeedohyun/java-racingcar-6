package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Utils;

public class InputView {

    public List<String> inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Utils.splitName(Console.readLine());
    }

    public int inputTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Utils.convertInt(Console.readLine());
    }
}
