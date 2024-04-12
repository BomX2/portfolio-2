package model;

import menu.Menu;
import utils.DataSeeder;

public class Beheerder extends Gebruiker{
    public Beheerder(String naam) {
        super(naam);
    }

    public void voegLandToe (){

    }
    @Override
    public void vraagOp() {

    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}
