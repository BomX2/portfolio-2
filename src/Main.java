import utils.*;
import menu.*;


public class Main {

    public static void main (String [] args) {

        DataSeeder seeder = DataSeeder.getInstance ();

        while (true) {
            Menu menu = seeder.getMenus().getMenu();
            menu.toonMenu();
        }
    }
}