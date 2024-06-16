package menu;

import utils.DataSeeder;

import java.util.Scanner;
import model.*;
import utils.Security;

public class ActieWerkBij implements IActie {
    @Override
    public void voerActieUit() {
        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);
        CaoMedewerker caoMedewerker = (CaoMedewerker) Security.getInstance().getActieveGebruiker();
        System.out.printf("=== %s%n", "alle geregistreerde vluchtelingen");
        DataSeeder.getInstance().getGebruikers().getAllAzielzoekers();
        System.out.printf("=== %s%n","geef de naam waarvan je het dossier aan wilt passen");
        String naam = scanner.nextLine();
        System.out.println("is er een paspoort getoond");
        System.out.println("ja on nee");
        String paspoort = scanner.nextLine();
        System.out.println("is de asielaanvraag compleet");
        System.out.println("ja on nee");
        String asiel = scanner.nextLine();
        System.out.println("Wat is de uitspraak");
        String uitspraak = scanner.nextLine();
        System.out.println("keert de vluchteling terug");
        System.out.println("ja on nee");
        String keertterug = scanner.nextLine();

        caoMedewerker.werkDosierBij(naam,paspoort,asiel,uitspraak,keertterug);

}
}
