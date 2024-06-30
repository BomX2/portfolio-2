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
        boolean paspoort = seeder.JaOfNee(scanner.nextLine());
        System.out.println("is de asielaanvraag compleet");
        System.out.println("ja on nee");
        boolean asiel = seeder.JaOfNee(scanner.nextLine());
        System.out.println("Wat is de uitspraak");
        String uitspraak = scanner.nextLine();
        System.out.println("keert de vluchteling terug");
        System.out.println("ja on nee");
        boolean keertterug = seeder.JaOfNee(scanner.nextLine());

        Asielzoeker asielzoeker = (Asielzoeker) DataSeeder.getInstance().getGebruikers().getVluchtelingBijNaam(naam);
        Dossier dossier = caoMedewerker.werkDosierBij(naam,asielzoeker.getLandVanHerkomst(),paspoort,asiel,uitspraak,keertterug);
        asielzoeker.setDossier(dossier);
}
}
