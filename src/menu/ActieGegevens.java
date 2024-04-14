package menu;

import model.Asielzoeker;
import utils.Security;

public class ActieGegevens implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        Asielzoeker asielzoeker = (Asielzoeker) security.getActieveGebruiker();
        System.out.println(asielzoeker.getNaam());
        System.out.println(asielzoeker.getLandVanHerkomst().getNaam());

        if (asielzoeker.getLandVanHerkomst().isVeilig()){
            System.out.println("land is veilig");
        } else {
            System.out.println("land is niet veilig");
        }


    }
}
