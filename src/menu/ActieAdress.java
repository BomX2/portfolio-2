package menu;

import model.Asielzoeker;
import utils.Security;

import java.util.Scanner;

public class ActieAdress implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        Asielzoeker asielzoeker = (Asielzoeker) security.getActieveGebruiker();

        if (asielzoeker.getDossier().getUitspraak().equals("geaccepteerd")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("voer uw nieuwe adress in");
            String adress = scanner.nextLine();
        } else {
            System.out.println("u heeft nog geen toegang tot deze functie");
            System.out.println("wacht totdat de rechter uitspraak heeft gedaan");
        }
    }
}
