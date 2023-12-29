package racingcar.model;

import java.util.Objects;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 4;
    private static final int MIN_FORWARD_THRESHOLD = 4;

    private final String name;
    private int location;

    private RacingCar(final String name, final int location) {
        validateName(name);
        this.name = name;
        this.location = location;
    }

    public static RacingCar create(final String name, final int location) {
        return new RacingCar(name, location);
    }

    public void move(final int random) {
        if (canMove(random)) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", location=" + location +
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
        RacingCar racingCar = (RacingCar) o;
        return location == racingCar.location && Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private boolean canMove(final int random) {
        return random >= MIN_FORWARD_THRESHOLD;
    }
}
