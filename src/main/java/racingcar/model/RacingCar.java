package racingcar.model;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_FORWARD_THRESHOLD = 4;

    private final String name;
    private int location;

    public RacingCar(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(final int random) {
        if (canMove(random)) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    private boolean canMove(final int random) {
        return random >= MIN_FORWARD_THRESHOLD;
    }
}
