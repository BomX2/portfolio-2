package model;

import menu.Menu;
import utils.*;

import java.util.ArrayList;

public class Asielzoeker extends Gebruiker {
    private ArrayList<Observer> observers= new ArrayList<>();
    private Land landVanHerkomst;
    private String nieuwAdress, gender;
    private Dossier dossier;
    private boolean familielid;
    private int leeftijd;
    private Observable observer;

    public Asielzoeker(String naam,String gender,int leeftijd, Land landVanHerkomst,Dossier dossier){
        super(naam);
        this.gender = gender;
        this.leeftijd = leeftijd;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
        this.nieuwAdress = null;

    }
    public Asielzoeker(String naam,String gender,int leeftijd, Land landVanHerkomst,Dossier dossier,Observable observable) {
        super(naam);
        this.gender = gender;
        this.leeftijd = leeftijd;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = dossier;
        this.nieuwAdress = null;
        observer = observable;
    }
    public void nieuwAdress(String plek) {
        this.nieuwAdress = plek;
        Bericht bericht = new Bericht("verhuizing " + getNaam(),getNaam(),getNaam() + "is verhuist naar"+ getNieuwAdress());
        observer.notifyObservers(bericht);

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
        System.out.printf("Plaatsing in eigen woning: %s%n",dossier.getUitspraak());
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getVluchtelingMenu();
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

    public String getNieuwAdress() {
        return nieuwAdress;
    }

    public void setNieuwAdress(String nieuwAdress) {
        this.nieuwAdress = nieuwAdress;
    }

    public boolean isFamilielid() {
        return familielid;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public String getGender() {
        return gender;
    }

    public void setFamilielid(boolean familielid) {
        this.familielid = familielid;
    }
}

