package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.model.dto.WinnersDto;

public class RacingCars {

    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름을 입력하면 안 됩니다.";
    private static final String WINNER_DELIMITER = ", ";

    private final List<RacingCar> racingCars;

    private RacingCars(final List<RacingCar> racingCars) {
        validateDuplicateName(racingCars);
        this.racingCars = racingCars;
    }

    public static RacingCars create(final List<RacingCarName> namesOfCars) {
        List<RacingCar> racingCars = namesOfCars.stream()
                .map(RacingCar::new)
                .toList();
        return new RacingCars(racingCars);
    }

    public RacingCars move(final RandomNumberGenerator randomNumberGenerator) {
        final List<RacingCar> movedRacingCars = racingCars.stream()
                .map(car -> car.move(randomNumberGenerator.generate()))
                .toList();
        return new RacingCars(movedRacingCars);
    }

    public WinnersDto findWinners() {
        final int maxLocationLength = getMaxLocationLength();
        final String winners = racingCars.stream()
                .filter(car -> car.getLocationLength() == maxLocationLength)
                .map(RacingCar::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
        return new WinnersDto(winners);
    }

    public List<String> getCurrentLocations() {
        return racingCars.stream()
                .map(RacingCar::getCurrentLocation)
                .toList();
    }

    @Override
    public String toString() {
        return "RacingCars{" +
                "racingCars=" + racingCars +
                '}';
    }

    private void validateDuplicateName(final List<RacingCar> racingCars) {
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
