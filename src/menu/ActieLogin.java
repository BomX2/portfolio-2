package menu;

import utils.Security;

public class ActieLogin implements IActie {

    @Override
    public void voerActieUit() {
        Security.getInstance ().login ();
    }
}