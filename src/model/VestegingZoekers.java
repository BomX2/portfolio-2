package model;

abstract class VestegingZoekers extends gebruiker{

    String naam;
    String landVanHerkomst;

    public VestegingZoekers(String naam, String landVanHerkomst){
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
    }

    public abstract void vraagDossierOp();

    public abstract void vraagGegevensOp();

    public abstract void nieuwAdress();

}
