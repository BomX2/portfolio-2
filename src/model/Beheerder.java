package model;

import menu.Menu;
import utils.*;

import java.util.ArrayList;

public class Beheerder extends Gebruiker{
    public Beheerder(String naam) {
        super(naam);
    }

    public void voegLandToe (String naam, boolean veilig){
        Land land = new Land(naam,veilig);
        DataSeeder.getInstance().getLanden().setLanden(land);
    }
    public void isVeilig (Land land, boolean veilig){
        land.setVeilig(veilig);
    }
    public void voegGemeentetoe (String naam , int aantalinwooners){
        Gemeente gemeente = new Gemeente(naam,aantalinwooners);
        DataSeeder.getInstance().getGemeentes().setGemeentes(gemeente);

    }
    @Override
    public void vraagOp() {
        ArrayList<Gemeente> gemeentes = DataSeeder.getInstance().getGemeentes().getGemeentes();
            for (Gemeente gemeente : gemeentes){
                int capaciteit = gemeente.capaciteit();
                int uitkering= Getuitkering(gemeente,capaciteit);
            System.out.printf("Gemeente %s: Opvangcapaciteit: %d, Uitkering: €%d%n",
                    gemeente.getNaam(), capaciteit, uitkering);
        }
    }
    public int Getuitkering(Gemeente gemeente, int capaciteit) {
        int uitkering = 0;

        if (capaciteit >= 100) {
            uitkering = 2000;
        } else if (capaciteit > 0) {
            uitkering = 1000;
        } else if (capaciteit == 0) {
            uitkering = 0;
        }

        return uitkering;
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getBeheerderMenu();
    }
}
