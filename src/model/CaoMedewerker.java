package model;

import utils.DataSeeder;

import menu.Menu;

import java.util.ArrayList;

public class CaoMedewerker extends Gebruiker {

    private ArrayList<Asielzoeker> asielzoekers;
    public CaoMedewerker(String naam) {
        super(naam);
        asielzoekers = new ArrayList<>();
    }

    public void registreerVluchteling (Dossier dossier) {

        String naam = dossier.getNaam();
        Land land = dossier.getLandVanHerkomst();
        Asielzoeker asielzoeker = new Asielzoeker(naam,land,dossier);
    }

    @Override
    public void vraagOp() {
        System.out.println("help");
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCaoMenu();
    }
}
