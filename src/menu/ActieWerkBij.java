package menu;

import utils.DataSeeder;
import utils.Security;

import java.util.Scanner;

public class ActieWerkBij implements IActie {
    @Override
    public void voerActieUit() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("=== %s%n", "alle geregistreerde vluchtelingen");
        DataSeeder.getInstance().getAllAzielzoekers();
        System.out.printf("=== %s%n","geef de naam waarvan je het dossier aan wilt passen");
        String naam = scanner.nextLine();


}
}
