package menu;

import model.Asielzoeker;
import model.CaoMedewerker;
import utils.Security;

public class ActieVraagOpC implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        CaoMedewerker caoMedewerker = (CaoMedewerker) security.getActieveGebruiker();
        caoMedewerker.vraagOp();

    }
}
