package model;

import menu.Menu;

public class vluchteling extends VestegingZoekers{
    public vluchteling(String naam, String landVanHerkomst) {
        super(naam, landVanHerkomst);
    }

    @Override
    public void vraagDossierOp() {

    }

    @Override
    public void vraagGegevensOp() {

    }

    @Override
    public void nieuwAdress() {

    }

    @Override
    public Menu getMenu() {
        return null;
    }
}
