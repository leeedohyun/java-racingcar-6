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

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<RacingCar> findWinners() {
        int max = cars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(racingCar -> racingCar.getLocation() == max)
                .toList();
    }

    @Override
    public String toString() {
        return "RacingCars{" +
                "cars=" + cars +
                '}';
    }
}
