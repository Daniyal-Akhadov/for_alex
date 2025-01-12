package by.daniyal;

import by.daniyal.utils.PropertiesUtil;

import java.util.Random;

public class SourceNumberGenerator {
    public static final String GAME_NUMBER_MAX = "game.number.max";
    private final Random random;

    public SourceNumberGenerator(Random random) {
        this.random = random;
    }

    public int generate() {
        String maxValue = PropertiesUtil.getValueBy(GAME_NUMBER_MAX);
        int parsedMaxValue = ParserToIntegerUtil.parse(maxValue);
        return random.nextInt(parsedMaxValue);
    }
}
