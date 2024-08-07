package utils;

import menu.*;
import model.Gebruiker;

import java.util.ArrayList;

public class Menus {
    private final ArrayList<Menu> menus;

    public Menus() {
        this.menus = new ArrayList<>();
    }

    public void initializeMenus(){
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
        Menukeuze uitkering = new Menukeuze("reken uitkering uit",new ActieUitkering());
        beheerderMenu.voegMenukeuzeToe(voegLand);
        beheerderMenu.voegMenukeuzeToe(veilig);
        beheerderMenu.voegMenukeuzeToe(voegGemeente);
        beheerderMenu.voegMenukeuzeToe(vraagOpB);
        beheerderMenu.voegMenukeuzeToe(uitkering);
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

        Menu azcmenu = new Menu("u bent ingelogd als Azc medewerker");
        Menukeuze bericht = new Menukeuze("berichtenbox",new ActieBericht());
        Menukeuze plaats = new Menukeuze("plaats asielzoeker",new ActiePlaats());
        azcmenu.voegMenukeuzeToe(plaats);
        azcmenu.voegMenukeuzeToe(bericht);
        azcmenu.voegMenukeuzeToe(logout);
        menus.add(azcmenu);
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

    public Menu getAzcMenu (){
        return menus.get(4);
    }
}
