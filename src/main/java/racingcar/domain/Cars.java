package racingcar.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름을 입력하면 안 됩니다.";

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        validateName(carList);
        this.carList = carList;
    }

    public List<String> moveCars(int randomNumber) {
        return carList.stream()
                .map(car -> car.move(randomNumber))
                .collect(Collectors.toList());
    }

    public List<Car> getWinnerCars() {
        return carList.stream()
                .filter(car -> car.getLocationLength() == getMaxLocationLength())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNamesOfCars(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateName(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);

        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private int getMaxLocationLength() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocationLength))
                .map(Car::getLocationLength)
                .get();
    }
}
