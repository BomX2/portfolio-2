package model;

import utils.DataSeeder;

import menu.Menu;

import java.util.ArrayList;

public class CaoMedewerker extends Gebruiker {

    private ArrayList<Dossier> dossiers;
    public CaoMedewerker(String naam) {
        super(naam);
        dossiers = new ArrayList<>();
    }

    public void registreerVluchteling (Dossier dossier) {
        dossiers.add(dossier);

    }

    @Override
    public void vraagOp() {

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCaoMenu();
    }
}
