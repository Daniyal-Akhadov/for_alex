package by.daniyal;

import by.daniyal.observer_pattern.Observer;
import by.daniyal.observer_pattern.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultSubject implements Subject<String> {
    private final List<Observer<String>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer<String> observer : observers) {
            observer.update(message);
        }
    }
}
