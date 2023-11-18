package racingcar.model;

import java.util.List;

public class RacingCarFactory {

    private RacingCarFactory() {
    }

    public static List<RacingCar> generateCar(final List<Name> namesOfCars) {
        return namesOfCars.stream()
                .map(RacingCar::new)
                .toList();
    }
}
