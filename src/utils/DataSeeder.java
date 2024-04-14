package utils;

import menu.*;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DataSeeder {
    private static DataSeeder instance = null;
    private ArrayList<Menu> menus;
    private ArrayList<Gebruiker> gebruikers;
    private ArrayList<Land> landen;
    private ArrayList<Gemeente> gemeentes;


    private void voegGebruikerToe(Gebruiker gebruiker) {

        for (Gebruiker g : gebruikers) {

            if (g.getNaam().equals(gebruiker.getNaam())) {
                return;
            }
        }

        gebruikers.add(gebruiker);
    }

    public void voegAsielzoekerToe(Asielzoeker asielzoeker) {
        voegGebruikerToe(asielzoeker);
    }

    private void voegMedewerkerToe(CaoMedewerker caoMedewerker) {
        voegGebruikerToe(caoMedewerker);
    }

    private void voegBeheerderToe(Beheerder beheerder) {
        voegGebruikerToe(beheerder);
    }


    private void initialize() {
        Land israel = new Land("israel",false);
        Gemeente denHaag = new Gemeente("den haag", 514861);
        Dossier dossierM = new Dossier("mohammad", israel, false);
        Asielzoeker asielzoeker = new Asielzoeker("amin", israel, dossierM);
        voegAsielzoekerToe(asielzoeker);
        landen.add(israel);
        gemeentes.add(denHaag);

        CaoMedewerker cao = new CaoMedewerker("jan");
        cao.registreerVluchteling(dossierM);
        voegMedewerkerToe(cao);

        Beheerder beheerder = new Beheerder("tony");
        voegBeheerderToe(beheerder);

        Menu uitgelogd = new Menu("U bent nog niet ingelogd");
        Menukeuze inloggen = new Menukeuze("Login", new ActieLogin());
        Menukeuze exit = new Menukeuze(9, "Exit", true, new ActieExit());
        uitgelogd.voegMenukeuzeToe(inloggen);
        uitgelogd.voegMenukeuzeToe(exit);
        menus.add(uitgelogd);

        Menu caoMenu = new Menu("u bent ingelogd als Cao medewerker");
        Menukeuze registreer = new Menukeuze("registreer een vluchteling", new ActieRegistreer());
        Menukeuze werkDosierBij = new Menukeuze("werk dossier bij", new ActieWerkBij());
        Menukeuze vraagOpC = new Menukeuze("gemeente opvragen", new ActieVraagOpC());
        Menukeuze logout = new Menukeuze(9, "logout", true, new ActieLogout());
        caoMenu.voegMenukeuzeToe(werkDosierBij);
        caoMenu.voegMenukeuzeToe(registreer);
        caoMenu.voegMenukeuzeToe(vraagOpC);
        caoMenu.voegMenukeuzeToe(logout);
        menus.add(caoMenu);


        Menu beheerderMenu = new Menu("u bent ingelogd als beheerder");
        Menukeuze voegLand = new Menukeuze("voeg een nieuw land toe", new ActieVoegLand());
        Menukeuze veilig = new Menukeuze("wijzig veiligheid van een land", new ActieVeilig());
        Menukeuze voegGemeente = new Menukeuze("voeg een nieuwe gemeente toe", new ActieGemeente());
        Menukeuze vraagOpB = new Menukeuze("vraag rapportage op van een gemeente", new ActieVraagOpB());
        beheerderMenu.voegMenukeuzeToe(voegLand);
        beheerderMenu.voegMenukeuzeToe(veilig);
        beheerderMenu.voegMenukeuzeToe(voegGemeente);
        beheerderMenu.voegMenukeuzeToe(vraagOpB);
        beheerderMenu.voegMenukeuzeToe(logout);
        menus.add(beheerderMenu);


        Menu vluchtelingMenu = new Menu("u bent ingelogd als asielzoeker");
        Menukeuze gegevens = new Menukeuze("vraag gegevens op", new ActieGegevens());
        Menukeuze dossier = new Menukeuze("vraag dossier op", new ActieDosier());
        Menukeuze nieuwAdress = new Menukeuze("registreer nieuw adress", new ActieAdress());
        vluchtelingMenu.voegMenukeuzeToe(gegevens);
        vluchtelingMenu.voegMenukeuzeToe(dossier);
        vluchtelingMenu.voegMenukeuzeToe(nieuwAdress);
        vluchtelingMenu.voegMenukeuzeToe(logout);
        menus.add(vluchtelingMenu);

    }

    private DataSeeder() {
        this.menus = new ArrayList<>();
        this.gebruikers = new ArrayList<>();
        this.landen = new ArrayList<>();
        this.gemeentes = new ArrayList<>();
        initialize();
    }

    public static DataSeeder getInstance() {
        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    public Menu getMenu() {

        Security security = Security.getInstance();

        if (!security.isIngelogd()) {
            return menus.get(0);
        } else {
            Gebruiker gebruiker = security.getActieveGebruiker();
            return gebruiker.getMenu();
        }

    }

    public Menu getCaoMenu() {
        return menus.get(1);
    }

    public Menu getBeheerderMenu() {
        return menus.get(2);
    }

    public Menu getVluchtelingMenu() {
        return menus.get(3);
    }

    public Gebruiker getGebruiker(String naam) {

        for (Gebruiker gebruiker : gebruikers) {

            if (gebruiker.login(naam)) {
                return gebruiker;
            }
        }

        return null;
    }

    public void getAllAzielzoekers() {
        for (Gebruiker gebruiker : gebruikers) {
            if (gebruiker instanceof Asielzoeker) {
                System.out.printf("Naam: %s%n", gebruiker.getNaam());
            }
        }
    }
    public Gebruiker getVluchtelingBijNaam (String naam){
            for(Gebruiker g : gebruikers){
                if (g.getNaam().equalsIgnoreCase(naam)){
                    return g;
                }
            }
            return null;
    }
    public boolean JaOfNee (String jaOfNee){
        if (jaOfNee.equalsIgnoreCase("ja")){
            return true;
        }
        return false;
    }

    public Land getLand (String naam) {
        for(Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(naam)){
                return land;
            }
        }
        return null;

    }
    public void getAllLanden (){
        for (Land land : landen){
            System.out.printf("naam: %s%n", land.getNaam());
        }
    }
    public void setLanden (Land land){
        landen.add(land);
    }
    public void setGemeentes (Gemeente gemeente) {
        gemeentes.add(gemeente);
    }

    public ArrayList<Gemeente> getGemeentes() {
        return gemeentes;
    }
}
