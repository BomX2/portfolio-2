package model;

import menu.Menu;
import utils.DataSeeder;

import java.util.Observable;
import java.util.Observer;

public class AzcMedewerker extends Gebruiker{
    public AzcMedewerker(String naam) {
        super(naam);
    }

    @Override
    public void vraagOp() {

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getAzcMenu();
    }

}
