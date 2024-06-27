package model;

import menu.Menu;
import utils.DataSeeder;

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
