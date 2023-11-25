package racingcar.model;

import java.util.Objects;

public class Location {

    private static final String FORWARD_MOVEMENT_INDICATOR = "-";

    private final String location;

    public Location(final String location) {
        this.location = location;
    }

    public Location goForward() {
        return new Location(location + FORWARD_MOVEMENT_INDICATOR);
    }

    public int getLocationLength() {
        return location.length();
    }

    @Override
    public String toString() {
        return "Location{" +
                "location='" + location + '\'' +
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
        Location location1 = (Location) o;
        return Objects.equals(location, location1.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    public String getLocation() {
        return location;
    }
}
