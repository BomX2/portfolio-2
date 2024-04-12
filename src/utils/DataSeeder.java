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

    private void voegAsielzoekerToe (Asielzoeker asielzoeker){
        voegGebruikerToe(asielzoeker);
    }
    private void voegMedewerkerToe (CaoMedewerker caoMedewerker){
        voegGebruikerToe(caoMedewerker);
    }
    private void voegBeheerderToe (Beheerder beheerder){
        voegGebruikerToe(beheerder);
    }


    private void initialize () {
        CaoMedewerker cao = new CaoMedewerker("jan");
        voegMedewerkerToe(cao);

        Asielzoeker asielzoeker = new Asielzoeker("mohammad","israel");
        voegAsielzoekerToe(asielzoeker);

        Beheerder beheerder = new Beheerder("sarah");
        voegBeheerderToe(beheerder);

        Menu uitgelogd = new Menu ("U bent nog niet ingelogd");
        Menukeuze inloggen = new Menukeuze ("Login", new ActieLogin ());
        Menukeuze exit = new Menukeuze (9, "Exit", true, new ActieExit ());
        uitgelogd.voegMenukeuzeToe (inloggen);
        uitgelogd.voegMenukeuzeToe (exit);
        menus.add (uitgelogd);

        Menu caoMenu = new Menu("u bent ingelogd als Cao medewerker");
        Menukeuze registreer = new Menukeuze("registreer een vluchteling", new ActieRegistreer());
        Menukeuze werkDosierBij = new Menukeuze("werk dossier bij",new ActieRegistreer());
        Menukeuze vraagOpC = new Menukeuze("gemeente opvragen", new ActieRegistreer());
        Menukeuze logout = new Menukeuze(9,"logout",true,new ActieLogout());
        caoMenu.voegMenukeuzeToe(werkDosierBij);
        caoMenu.voegMenukeuzeToe(registreer);
        caoMenu.voegMenukeuzeToe(vraagOpC);
        caoMenu.voegMenukeuzeToe(logout);
        menus.add(caoMenu);


        Menu beheerderMenu = new Menu("u bent ingelogd als beheerder");
        Menukeuze voegLand = new Menukeuze("voeg een nieuw land toe", new ActieRegistreer());
        Menukeuze veilig = new Menukeuze("wijzig veiligheid van een land", new ActieRegistreer());
        Menukeuze voegGemeente = new Menukeuze("voeg een nieuwe gemeente toe", new ActieRegistreer());
        Menukeuze vraagOpB = new Menukeuze("vraag rapportage op van een gemeente", new ActieRegistreer());
        beheerderMenu.voegMenukeuzeToe(voegLand);
        beheerderMenu.voegMenukeuzeToe(veilig);
        beheerderMenu.voegMenukeuzeToe(voegGemeente);
        beheerderMenu.voegMenukeuzeToe(vraagOpB);
        beheerderMenu.voegMenukeuzeToe(logout);
        menus.add(beheerderMenu);


        Menu vluchtelingMenu = new Menu("u bent ingelogd als asielzoeker");
        Menukeuze gegevens = new Menukeuze("vraag gegevens op", new ActieRegistreer());
        Menukeuze nieuwAdress = new Menukeuze("registreer nieuw adress", new ActieRegistreer());
        vluchtelingMenu.voegMenukeuzeToe(gegevens);
        vluchtelingMenu.voegMenukeuzeToe(nieuwAdress);
        vluchtelingMenu.voegMenukeuzeToe(logout);
        menus.add(vluchtelingMenu);

    }
    private DataSeeder(){
        this.menus = new ArrayList<>();
        this.gebruikers = new ArrayList<>();
        initialize();
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

    public Menu getCaoMenu (){
        return  menus.get(1);
    }
    public Menu getBeheerderMenu (){
        return menus.get(2);
    }
    public Menu getVluchtelingMenu () {
        return menus.get(3);
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
