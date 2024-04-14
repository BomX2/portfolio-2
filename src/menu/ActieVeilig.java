package menu;

import model.Beheerder;
import model.Land;
import utils.DataSeeder;
import utils.Security;

import java.util.Scanner;

public class ActieVeilig implements IActie{
    @Override
    public void voerActieUit() {
        Scanner scanner = new Scanner(System.in);
        DataSeeder seeder = DataSeeder.getInstance();
        Security security = Security.getInstance();
        Beheerder beheerder = (Beheerder) security.getActieveGebruiker();
        seeder.getAllLanden();
        System.out.println("geef de naam van het land waar u de veiligheid van wilt wijzigen");
        String naam = scanner.nextLine();
        System.out.println("is het land veilig");
        String veilig = scanner.nextLine();

        Land land = seeder.getLand(naam);
        beheerder.isVeilig(land,seeder.JaOfNee(veilig));

    }
}
