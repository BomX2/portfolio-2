package menu;

import model.Beheerder;
import utils.Security;

import java.util.Scanner;

public class ActieGemeente implements IActie{
    @Override
    public void voerActieUit() {
        Scanner scanner = new Scanner(System.in);
        Security security = Security.getInstance();
        Beheerder beheerder = (Beheerder) security.getActieveGebruiker();
        System.out.println("geef de naam van de gemeente op");
        String naam = scanner.nextLine();
        System.out.println("hoeveel inwoners heeft deze gemeente");
        int inwooners = scanner.nextInt();

        beheerder.voegGemeentetoe(naam,inwooners);
    }
}
