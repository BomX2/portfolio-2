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
                double uitkering = Getuitkering(gemeente,capaciteit);

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

    public double getuitkeringExtra(int inwoners, int vluchtelingen, int extravluchtelingen, int azcCapaciteit) {
        double basis = 1000.0;
        double extra = 2000.0;
        double capaciteitBonus = 500.0;

        double uitkering = 0.0;

        if (inwoners < 1000) {
            uitkering += 500;
        } else if (inwoners <= 5000) {
            uitkering += 1000;
        } else {
            uitkering += 1500;
        }

        if (vluchtelingen >= 0.5 * inwoners) {
            uitkering += basis;
        }

        if (extravluchtelingen > 100) {
            uitkering +=  extra;
        }

        if (azcCapaciteit >= 100) {
            uitkering += capaciteitBonus;
        }

        return uitkering;
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getBeheerderMenu();
    }
}
