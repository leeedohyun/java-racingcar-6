package racingcar.model;

import java.util.List;

public class RacingCarFactory {

    private RacingCarFactory() {
    }

    public static List<RacingCar> generateCar(List<Name> namesOfCars) {
        return namesOfCars.stream()
                .map(carName -> new RacingCar(carName))
                .toList();
    }
}
