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

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(String landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
}