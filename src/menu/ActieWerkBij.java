package menu;

import utils.DataSeeder;

import java.util.Scanner;
import model.*;

public class ActieWerkBij implements IActie {
    @Override
    public void voerActieUit() {
        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("=== %s%n", "alle geregistreerde vluchtelingen");
        DataSeeder.getInstance().getAllAzielzoekers();
        System.out.printf("=== %s%n","geef de naam waarvan je het dossier aan wilt passen");
        String naam = scanner.nextLine();
        System.out.println("is er een paspoort getoond");
        String paspoort = scanner.nextLine();
        System.out.println("is de asielaanvraag compleet");
        String asiel = scanner.nextLine();
        System.out.println("is er een rechter toe gewezen");
        String rechter = scanner.nextLine();
        System.out.println("heeft de rechter uitspraak gedaan");
        String uitspraakgedaan = scanner.nextLine();
        System.out.println("Wat is de uitspraak");
        String uitspraak = scanner.nextLine();
        System.out.println("keert de vluchteling terug");
        String keertterug = scanner.nextLine();

        Asielzoeker asielzoeker = (Asielzoeker) DataSeeder.getInstance().getVluchtelingBijNaam(naam);
        Dossier dossier = new Dossier(asielzoeker.getNaam(),asielzoeker.getLandVanHerkomst(),seeder.JaOfNee(paspoort),seeder.JaOfNee(asiel),seeder.JaOfNee(rechter),uitspraakgedaan,uitspraak,seeder.JaOfNee(keertterug));
        asielzoeker.setDossier(dossier);


}
}
