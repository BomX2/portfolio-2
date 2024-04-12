package model;

import menu.Menu;
import utils.DataSeeder;

public class Asielzoeker extends Gebruiker{
    private String landVanHerkomst;

    public Asielzoeker(String naam, String landVanHerkomst) {
        super(naam);
        this.landVanHerkomst = landVanHerkomst;
    }

    public void nieuwAdress() {

    }

    @Override
    public void vraagOp() {

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }
}
