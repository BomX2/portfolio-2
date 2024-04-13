package model;

import menu.Menu;
import utils.DataSeeder;

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
    @Override
    public void vraagOp() {
        System.out.println("help");
    }

    @Override
    public Menu getMenu() {
        return DataSeeder.getInstance().getBeheerderMenu();
    }
}
