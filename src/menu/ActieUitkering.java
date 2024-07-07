package menu;

import model.Beheerder;
import utils.Security;

import java.util.Scanner;

public class ActieUitkering implements IActie{

    @Override
    public void voerActieUit() {
        Beheerder beheerder = (Beheerder) Security.getInstance().getActieveGebruiker();
        Scanner scanner = new Scanner(System.in);
        int inwoners = scanner.nextInt();
        int vluchtelingen= scanner.nextInt();
        int capaciteit= scanner.nextInt();
        int extra= scanner.nextInt();
        beheerder.getuitkeringExtra(inwoners,vluchtelingen,extra,capaciteit);
    }
}
