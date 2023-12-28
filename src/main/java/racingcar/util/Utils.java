package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Utils {

    private static final String RACING_CAR_NAME_SPLITER = ",";

    private Utils() {
    }

    public static List<String> splitName(final String name) {
        return Arrays.stream(name.split(RACING_CAR_NAME_SPLITER))
                .toList();
    }

    public static int convertInt(final String tryNumber) {
        try {
            return Integer.parseInt(tryNumber);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
