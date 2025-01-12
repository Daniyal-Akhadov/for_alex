package by.daniyal;

public interface Game<T> {
    void start();

    void userInput(T input);

    void end();
}
