package by.daniyal;

import by.daniyal.utils.logger.ConsolerLogger;
import by.daniyal.utils.logger.Logger;
import by.daniyal.view.GameDisplay;

import java.util.Random;
import java.util.Scanner;

public class EntryPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInput userInput = new UserInput(scanner);
        Logger logger = new ConsolerLogger();
        GameDisplay inputDisplay = new GameDisplay(userInput, logger);
        Random random = new Random();
        SourceNumberGenerator sourceNumberGenerator = new SourceNumberGenerator(random);
        GuessedNumberGame guessedNumberGame = new GuessedNumberGame(sourceNumberGenerator, userInput);
        GameDisplay gameDisplay = new GameDisplay(guessedNumberGame, logger);

        guessedNumberGame.start();
    }
}

