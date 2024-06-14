package utils;

import model.observer;

import java.util.ArrayList;

public class AppListener implements observer {
    private String naam;
    private ArrayList<String> notificaties;

    public AppListener (String naam){
        this.naam = naam;
        this.notificaties = new ArrayList<>();
    }

    @Override
    public void update(String message) {
        notificaties.add(message);
    }
}
