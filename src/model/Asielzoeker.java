package model;

import menu.Menu;
import utils.DataSeeder;

public class Asielzoeker extends Gebruiker{
    private String landVanHerkomst;
    private Dossier dossier;

    public Asielzoeker(String naam, String landVanHerkomst,Dossier dossier) {
        super(naam);
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
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