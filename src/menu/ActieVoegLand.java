package menu;

import model.Beheerder;
import utils.DataSeeder;
import utils.Security;

import java.util.Scanner;

public class ActieVoegLand implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        Beheerder beheerder = (Beheerder) security.getActieveGebruiker();
        Scanner scanner = new Scanner(System.in);
        System.out.println("voer de naam van het land in");
        String naam = scanner.nextLine();
        System.out.println("is het land veilig");
        System.out.println("ja on nee");
        boolean veilig = DataSeeder.getInstance().JaOfNee(scanner.nextLine());
        beheerder.voegLandToe(naam,veilig);
    }
}
