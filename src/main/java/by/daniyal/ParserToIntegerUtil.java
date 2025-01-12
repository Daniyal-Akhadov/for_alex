package by.daniyal;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParserToIntegerUtil {

    public static <FROM> int parse(FROM value) {
        Class<?> targetType = value.getClass();

        return switch (targetType.getSimpleName()) {
            case "String", "Float", "Double", "Integer",
                 "Long", "Timestamp", "Time", "Date",
                 "Boolean", "BigInteger", "BigDecimal" -> Integer.parseInt(value.toString());
            default -> throw new UnsupportedOperationException("Unsupported type: " + targetType.getSimpleName());
        };
    }
}
