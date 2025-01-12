package by.daniyal.view;

import by.daniyal.observer_pattern.Observer;
import by.daniyal.observer_pattern.Subject;
import by.daniyal.utils.logger.Logger;

public class GameDisplay implements Observer<String> {
    private final Subject<String> subject;
    private final Logger logger;

    public GameDisplay(Subject<String> subject, Logger logger) {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.logger = logger;
    }

    @Override
    public void update(String subject) {
        logger.log(subject);
    }
}

