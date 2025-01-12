package by.daniyal.observer_pattern;


public interface Subject<Type> {
    void registerObserver(Observer<Type> observer);

    void removeObserver(Observer<Type> observer);

    void notifyObservers(Type data);
}

