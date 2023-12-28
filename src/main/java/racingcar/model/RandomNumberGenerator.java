package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    public int generate() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }
}
