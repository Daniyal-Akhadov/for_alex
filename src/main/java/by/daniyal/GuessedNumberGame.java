package by.daniyal;

import by.daniyal.utils.PropertiesUtil;

import java.util.InputMismatchException;

import static by.daniyal.view.GameDisplayMessages.*;

public class GuessedNumberGame extends DefaultSubject implements Game<Integer> {
    private final SourceNumberGenerator sourceNumberGenerator;
    private final UserInput userInput;
    private boolean isWin;

    public GuessedNumberGame(SourceNumberGenerator sourceNumberGenerator, UserInput userInput) {
        this.sourceNumberGenerator = sourceNumberGenerator;
        this.userInput = userInput;
    }

    @Override
    public void start() {
        notifyObservers(SEPARATOR);
        notifyObservers(ROULETTE);
        final int minNumber = ParserToIntegerUtil.parse(PropertiesUtil.getValueBy("game.number.min"));
        final int maxNumber = ParserToIntegerUtil.parse(PropertiesUtil.getValueBy("game.number.max"));
        final String sector = SECTOR.formatted(minNumber, maxNumber);
        int attemptCount = ParserToIntegerUtil.parse(PropertiesUtil.getValueBy("game.number.attempts"));

        notifyObservers(sector);
        notifyObservers(SEPARATOR);
        notifyObservers(INDENT);

        final int sourceNumber = sourceNumberGenerator.generate();

        while (attemptCount >= 0) {
            try {
                int userGuessedNumber = userInput.askUserNumber();
                if (userGuessedNumber < minNumber || userGuessedNumber > maxNumber) {
                    notifyObservers(MISTAKE_BY_USER);
                }
                if (sourceNumber == userGuessedNumber) {
                    notifyObservers(YOU_WIN);
                    notifyObservers(WIN_NUMBER.formatted(sourceNumber));
                    break;
                }

                attemptCount--;

                if (isAttemptsFinished(attemptCount)) {
                    notifyObservers(WIN_NUMBER.formatted(sourceNumber));
                    notifyObservers(YOU_LOSE);
                    break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                notifyObservers(MISTAKE_BY_USER);
            }
        }

        userInput.close();
    }

    private static boolean isAttemptsFinished(int attemptCount) {
        return attemptCount == 0;
    }

    @Override
    public void userInput(Integer input) {

    }

    @Override
    public void end() {

    }
}
