package model;

abstract class VestegingZoekers extends Gebruiker{

    String naam;
    String landVanHerkomst;

    public VestegingZoekers(String naam, String landVanHerkomst){
        super(naam);
        this.landVanHerkomst = landVanHerkomst;
    }

    public abstract void vraagDossierOp();

    public abstract void vraagGegevensOp();

    public abstract void nieuwAdress();

}
