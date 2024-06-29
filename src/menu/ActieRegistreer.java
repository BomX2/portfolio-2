package menu;

import utils.DataSeeder;
import model.*;
import utils.Security;

import java.util.Scanner;

public class ActieRegistreer implements IActie{
    @Override
    public void voerActieUit() {
        CaoMedewerker caoMedewerker = (CaoMedewerker) Security.getInstance().getActieveGebruiker();

        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("geef de naam op");
        String naam = scanner.nextLine();
        System.out.println("geef de leeftijd");
        int leeftijd = scanner.nextInt();
        System.out.println("wat is de gender");
        String gender = scanner.nextLine();
        System.out.println("geef land van herkomst op");
        String land = scanner.nextLine();
        System.out.println("kan er een paspoort getoont worden");
        System.out.println("ja on nee");
        String paspoort = scanner.nextLine();

        Land land1 = DataSeeder.getInstance().getLanden().getLand(land);
        Dossier dossier = new Dossier(naam,land1,seeder.JaOfNee(paspoort));
        caoMedewerker.registreerVluchteling(dossier,gender,leeftijd);
    }
}
