package menu;

import model.Asielzoeker;
import model.Azc;
import utils.DataSeeder;

import java.util.Scanner;

public class ActiePlaats implements IActie{

    @Override
    public void voerActieUit() {
        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("voer naam in van de asielzoeker die u wilt verplaatsen");
        String naam = scanner.nextLine();
        System.out.println("geef de gemeente van de azc op");
        String gemeente = scanner.nextLine();
        System.out.println("en de postcode");
        String postcode = scanner.nextLine();
        Asielzoeker asielzoeker = (Asielzoeker) seeder.getGebruikers().getVluchtelingBijNaam(naam);
        Azc azc = seeder.getGemeentes().getGemeente(gemeente).getAzc(postcode);

        if (azc.plaatsAsiel(asielzoeker)){
            System.out.println("asiel zoeker geplaatst in kamer");
        } else {
            System.out.println("geen open kamers");
        }

    }
}
