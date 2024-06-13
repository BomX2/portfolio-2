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
        DataSeeder.getInstance().setLanden(land);
    }
    public void isVeilig (Land land, boolean veilig){
        land.setVeilig(veilig);
    }
    public void voegGemeentetoe (String naam , int aantalinwooners){
        Gemeente gemeente = new Gemeente(naam,aantalinwooners);
        DataSeeder.getInstance().setGemeentes(gemeente);

    }
    @Override
    public void vraagOp() {
        ArrayList<Gemeente> gemeentes = DataSeeder.getInstance().getGemeentes();

        for (Gemeente gemeente : gemeentes){
            int aantalInwoners = gemeente.getInwoners();
            int capaciteit = (int) (aantalInwoners * 0.005);
            int uitkering;

            if (capaciteit > 100) {
                uitkering = 2000;
            } else if (capaciteit < 100) {
                uitkering = 1000;
            } else {
                uitkering = 0;
            }

            System.out.printf("Gemeente %s: Opvangcapaciteit: %d, Uitkering: €%d%n",
                    gemeente.getNaam(), capaciteit, uitkering);
        }

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}
