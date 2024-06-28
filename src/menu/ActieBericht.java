package menu;

import model.AzcMedewerker;
import model.Gebruiker;
import utils.Security;

public class ActieBericht implements IActie{
    @Override
    public void voerActieUit() {
        AzcMedewerker azcMedewerker = (AzcMedewerker) Security.getInstance().getActieveGebruiker();

        azcMedewerker.vraagOp();
    }
}
