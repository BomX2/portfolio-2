package model;

import menu.Menu;

public class AzcMedewerker extends Gebruiker{
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
}
