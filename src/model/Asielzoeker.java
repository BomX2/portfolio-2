package model;

import menu.Menu;
import utils.DataSeeder;
import utils.observable;
import utils.observer;

import java.util.ArrayList;
import java.util.Observer;

public class Asielzoeker extends Gebruiker implements observable {
    private ArrayList<observer> observers= new ArrayList<>();
    private Land landVanHerkomst;
    private Dossier dossier;

    public Asielzoeker(String naam, Land landVanHerkomst,Dossier dossier) {
        super(naam);
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String message) {

    }

    public void nieuwAdress(String plek) {

    }

    @Override
    public void vraagOp() {
        if (dossier.isPaspoort()){
            System.out.println("Paspoort getoond: ja");
        } else {
            System.out.println("Paspoort getoond: nee");
        }
        if (dossier.isAsielaanvraag()){
            System.out.println("Asielaanvraag is compleet: ja");
        } else {
            System.out.println("Asielaanvraag is compleet: nee");
        }
        if (dossier.isRechterToeGewezen()){
            System.out.println("Rechter toegewezen: ja");
        } else {
            System.out.println("Rechter toegewezen: nee");
        }
        System.out.printf("Rechter heeft uitspraak gedaan: %s%n",dossier.getUitspraakGedaan());
        System.out.printf("Plaatsing in eigen woning: %s%n",dossier.getUitspraak());
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getVluchtelingMenu();
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

}