package racingcar.model;

import java.util.Objects;

public class RacingCarName {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "5자 이하의 이름만 가능합니다.";
    private static final String BLANK = " ";
    private static final String CAR_NAME_BLANK_EXCEPTION_MESSAGE = "자동차 이름에 공백이 있으면 안 됩니다.";

    private final String name;

    public RacingCarName(final String name) {
        validateCarNameLength(name);
        validateCarNameHasBlank(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RacingCarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCarName racingCarName1 = (RacingCarName) o;
        return Objects.equals(name, racingCarName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateCarNameLength(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateCarNameHasBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION_MESSAGE);
        }
    }
}
