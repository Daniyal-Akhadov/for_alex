package by.daniyal;

import java.util.InputMismatchException;
import java.util.Scanner;

import static by.daniyal.view.GameDisplayMessages.ENTER_YOUR_MOVE;

public class UserInput extends DefaultSubject {
    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int askUserNumber() {
        notifyObservers(ENTER_YOUR_MOVE);
        int userNumber;
        try {
            userNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            throw new InputMismatchException();
        }

        return userNumber;
    }

    public void close() {
        scanner.close();
    }
}

