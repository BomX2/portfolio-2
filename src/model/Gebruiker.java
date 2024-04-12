package model;

import menu.Menu;

public abstract class Gebruiker {
    private String naam;

    private void setNaam (String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return this.naam;
    }

    public Gebruiker (String naam){
        setNaam(naam);
    }
    public boolean login (String gebruikersnaam) {
        return this.getNaam ().equals (gebruikersnaam);
    }

    public abstract void vraagOp();
    public abstract Menu getMenu ();
}
