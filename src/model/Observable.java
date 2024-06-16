package model;

import java.util.ArrayList;

public class Observable {
    private final ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);

    }
    public void notifyObservers(Bericht bericht){
        observers.forEach(observer -> observer.update(bericht));
    }

}
