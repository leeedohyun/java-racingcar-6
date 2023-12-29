package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars) {
        this.cars = cars;
    }

    public void move(final RandomNumberGenerator randomNumberGenerator) {
        cars.forEach(racingCar -> racingCar.move(randomNumberGenerator.generate()));
    }

    public List<RacingCar> findWinners() {
        return cars.stream()
                .filter(this::isMaxLocation)
                .toList();
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "RacingCars{" +
                "cars=" + cars +
                '}';
    }

    private int getMaxLocation() {
        return cars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);
    }

    private boolean isMaxLocation(final RacingCar racingCar) {
        return racingCar.getLocation() == getMaxLocation();
    }
}
