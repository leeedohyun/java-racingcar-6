package racingcar.model;

import java.util.Objects;

public class RacingCar {

    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String SEPARATOR = " : ";
    private static final String START_LOCATION = "";

    private final RacingCarName racingCarName;
    private final Location location;

    public RacingCar(final RacingCarName racingCarName) {
        this.racingCarName = racingCarName;
        location = new Location(START_LOCATION);
    }

    public RacingCar(final RacingCarName racingCarName, final Location location) {
        this.racingCarName = racingCarName;
        this.location = location;
    }

    public RacingCar move(final int randomNumber) {
        if (isForward(randomNumber)) {
            final Location movedLocation = location.goForward();
            return new RacingCar(racingCarName, movedLocation);
        }
        return new RacingCar(racingCarName, location);
    }

    public int getLocationLength() {
        return location.getLocationLength();
    }

    public String getName() {
        return racingCarName.getName();
    }

    public String getCurrentLocation() {
        return getName() + SEPARATOR + location.getLocation();
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name=" + racingCarName +
                ", location=" + location +
                '}';
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
        return Objects.equals(racingCarName, racingCar.racingCarName) && Objects.equals(location, racingCar.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarName);
    }

    private boolean isForward(final int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }
}
