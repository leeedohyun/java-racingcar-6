package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름을 입력하면 안 됩니다.";
    private static final String WINNER_DELIMITER = ", ";

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateDuplicateName(racingCars);
        this.racingCars = racingCars;
    }

    public List<RacingCar> move(RandomNumberGenerator randomNumberGenerator) {
        return racingCars.stream()
                .map(car -> car.move(randomNumberGenerator.generate()))
                .toList();
    }

    public String findWinners() {
        int maxLocationLength = getMaxLocationLength();
        return racingCars.stream()
                .filter(car -> car.getLocationLength() == maxLocationLength)
                .map(RacingCar::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void validateDuplicateName(List<RacingCar> racingCars) {
        Set<RacingCar> duplicateRacingCars = new HashSet<>(racingCars);

        if (racingCars.size() != duplicateRacingCars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private int getMaxLocationLength() {
        return racingCars.stream()
                .mapToInt(RacingCar::getLocationLength)
                .max()
                .orElse(0);
    }
}
