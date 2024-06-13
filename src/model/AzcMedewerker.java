package model;

import menu.Menu;

import java.util.Observable;
import java.util.Observer;

public class AzcMedewerker extends Gebruiker implements Observer {
    public AzcMedewerker(String naam) {
        super(naam);
    }

    @Override
    public void vraagOp() {

    }

    @Override
    public Menu getMenu() {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
