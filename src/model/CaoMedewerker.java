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

    public Asielzoeker registreerVluchteling (Dossier dossier) {

        String naam = dossier.getNaam();
        Land land = dossier.getLandVanHerkomst();
        Asielzoeker asielzoeker = new Asielzoeker(naam,land,dossier);
        return asielzoeker;
    }
    public void werkDosierBij(String naam,String paspoort, String asiel, String rechter, String uitspraakgedaan, String uitspraak, String keertterug){
        DataSeeder seeder = DataSeeder.getInstance();
        Asielzoeker asielzoeker = (Asielzoeker) DataSeeder.getInstance().getVluchtelingBijNaam(naam);
        boolean paspoort1 = seeder.JaOfNee(paspoort);
        boolean asiel1 = seeder.JaOfNee(asiel);
        boolean rechter1 = seeder.JaOfNee(rechter);
        boolean keert = seeder.JaOfNee(keertterug);
        Dossier dossier = new Dossier(asielzoeker.getNaam(),asielzoeker.getLandVanHerkomst(),paspoort1,asiel1,rechter1,uitspraakgedaan,uitspraak,keert);
        asielzoeker.setDossier(dossier);
    }

    @Override
    public void vraagOp() {
        ArrayList<Gemeente> gemeentes = DataSeeder.getInstance().getGemeentes();

        for (Gemeente gemeente : gemeentes) {
            System.out.printf("Gemeente: %s",gemeente.getNaam());
        }
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getCaoMenu();
    }
}
