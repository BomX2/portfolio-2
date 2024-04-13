package menu;

import model.Beheerder;
import model.CaoMedewerker;
import utils.Security;

public class ActieVraagOpB implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        Beheerder beheerder = (Beheerder) security.getActieveGebruiker();
        beheerder.vraagOp();
    }
}
