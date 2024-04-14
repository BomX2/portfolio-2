package menu;

import utils.DataSeeder;
import model.*;

import java.util.Scanner;

public class ActieRegistreer implements IActie{
    @Override
    public void voerActieUit() {
        DataSeeder seeder = DataSeeder.getInstance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("geef de naam op");
        String naam = scanner.nextLine();
        System.out.println("geef land van herkomst op");
        String land = scanner.nextLine();
        System.out.println("kan er een paspoort getoont worden");
        System.out.println("ja on nee");
        String paspoort = scanner.nextLine();

        Land land1 = DataSeeder.getInstance().getLand(land);
        Dossier dossier = new Dossier(naam,land1,seeder.JaOfNee(paspoort));
        Asielzoeker asielzoeker = new Asielzoeker(naam,land1,dossier);
        seeder.voegAsielzoekerToe(asielzoeker);

    }
}
