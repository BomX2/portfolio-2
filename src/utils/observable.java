package utils;

import java.util.Observer;

public interface observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);

}
