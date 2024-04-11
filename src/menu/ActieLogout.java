package menu;

import utils.Security;

public class ActieLogout implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance ().logout ();
    }
}