package model;

import utils.*;

import menu.Menu;

import java.util.ArrayList;

public class CaoMedewerker extends Gebruiker {

    private ArrayList<Asielzoeker> asielzoekers;
    public CaoMedewerker(String naam) {
        super(naam);
        asielzoekers = new ArrayList<>();
    }

    public Asielzoeker registreerVluchteling (Dossier dossier,String gender,int leeftijd) {

        String naam = dossier.getNaam();
        Land land = dossier.getLandVanHerkomst();
        Asielzoeker asielzoeker = new Asielzoeker(naam,gender,leeftijd,land,dossier);
        return asielzoeker;
    }
    public Dossier werkDosierBij(String naam,Land land,boolean paspoort, boolean asiel, String uitspraak, boolean keertterug){
        boolean paspoort1 = paspoort;
        boolean asiel1 = asiel;
        boolean keert = keertterug;
        Dossier dossier = new Dossier(naam,land,paspoort1,asiel1,uitspraak,keert);
        return dossier;
    }

    @Override
    public void vraagOp() {
        ArrayList<Gemeente> gemeentes = DataSeeder.getInstance().getGemeentes().getGemeentes();

        for (Gemeente gemeente : gemeentes) {
            System.out.printf("Gemeente: %s",gemeente.getNaam());
        }
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getCaoMenu();
    }
}
