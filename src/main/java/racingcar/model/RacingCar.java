package racingcar.model;

import java.util.Objects;

public class RacingCar {

    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String SEPARATOR = " : ";
    private static final String START_LOCATION = "";

    private final Name name;
    private final Location location;

    public RacingCar(final Name name) {
        this.name = name;
        location = new Location(START_LOCATION);
    }

    public RacingCar(final Name name, final Location location) {
        this.name = name;
        this.location = location;
    }

    public RacingCar move(final int randomNumber) {
        if (isForward(randomNumber)) {
            final Location movedLocation = location.goForward();
            return new RacingCar(name, movedLocation);
        }
        return new RacingCar(name, location);
    }

    public int getLocationLength() {
        return location.getLocationLength();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name) && Objects.equals(location, racingCar.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName() + SEPARATOR + location;
    }

    private boolean isForward(final int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }
}
