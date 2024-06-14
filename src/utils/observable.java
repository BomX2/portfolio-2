package utils;

import java.util.ArrayList;
import java.util.Observer;

public class observable {
    private final ArrayList<observer> observers;

    public observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(observer observer){
        observers.add(observer);
    }
    public void removeObserver(observer observer){
        observers.remove(observer);

    }
    public void notifyObservers(String message){
        observers.forEach(observer -> observer.update(message));
    }

}
