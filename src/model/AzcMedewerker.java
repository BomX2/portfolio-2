package model;

import menu.Menu;
import utils.DataSeeder;

import java.util.ArrayList;

public class AzcMedewerker extends Gebruiker{
    private Azc azc;

    public AzcMedewerker(String naam,Azc azc) {
        super(naam);
        this.azc = azc;
    }

    @Override
    public void vraagOp() {
        ArrayList<Bericht> berichts = azc.getBerichtenbox().getBerichten();
        for (Bericht bericht : berichts){
            System.out.println(bericht.getNaam()+ "" + bericht.getOnderwerp());
        }
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getMenus().getAzcMenu();
    }

}
