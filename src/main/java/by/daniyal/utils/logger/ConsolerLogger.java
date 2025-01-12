package by.daniyal.utils.logger;

public class ConsolerLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
