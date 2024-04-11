package model;

import menu.Menu;

public class CaoMedewerker extends Gebruiker {
    public CaoMedewerker(String naam) {
        super(naam);
    }

    @Override
    public Menu getMenu() {
        return null;
    }
}
