package utils;

import menu.*;
import model.*;

import java.util.ArrayList;

public class DataSeeder {
    private static DataSeeder instance = null;
    private ArrayList<Menu> menus;
    private ArrayList<Gebruiker> gebruikers;

    private void voegGebruikerToe (Gebruiker gebruiker) {

        for (Gebruiker g : gebruikers) {

            if (g.getNaam ().equals (gebruiker.getNaam ())) {
                return;
            }
        }

        gebruikers.add (gebruiker);
    }


    private void initialize () {
        CaoMedewerker cao = new CaoMedewerker("a");
        voegGebruikerToe(cao);

        Menu uitgelogd = new Menu ("U bent nog niet ingelogd");
        Menukeuze inloggen = new Menukeuze ("Login", new ActieLogin ());
        Menukeuze exit = new Menukeuze (9, "Exit", true, new ActieExit ());
        uitgelogd.voegMenukeuzeToe (inloggen);
        uitgelogd.voegMenukeuzeToe (exit);
        menus.add (uitgelogd);

        Menu CaoMenu = new Menu("u bent ingelogd als Cao medewerker");


    }
    private DataSeeder(){
        this.menus = new ArrayList<>();
        this.gebruikers = new ArrayList<>();
    }

    public static DataSeeder getInstance(){
        if (instance == null){
            instance = new DataSeeder();
        }
        return instance;
    }
    public Menu getMenu () {

        Security security = Security.getInstance ();

        if (!security.isIngelogd ()) {
            return menus.get (0);
        }
        else {
            Gebruiker gebruiker = security.getActieveGebruiker ();
            return gebruiker.getMenu ();
        }

    }
    public Gebruiker getGebruiker (String naam) {

        for (Gebruiker gebruiker : gebruikers) {

            if (gebruiker.login (naam)) {
                return gebruiker;
            }
        }

        return null;
    }

}
