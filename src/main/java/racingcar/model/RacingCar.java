package racingcar.model;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 4;
    private final String name;

    public RacingCar(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
