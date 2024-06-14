package model;

import java.util.ArrayList;

public class observable {
    private final ArrayList<Observer> observers;

    public observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);

    }
    public void notifyObservers(String message){
        observers.forEach(observer -> observer.update(message));
    }

}
