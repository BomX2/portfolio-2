package utils;

import menu.*;
import model.Gebruiker;

import java.util.ArrayList;

public class menus {
    public void initializeMenus(){
        Menu uitgelogd = new Menu("U bent nog niet ingelogd");
        Menukeuze inloggen = new Menukeuze("Login", new ActieLogin());
        Menukeuze exit = new Menukeuze(9, "Exit", true, new ActieExit());
        uitgelogd.voegMenukeuzeToe(inloggen);
        uitgelogd.voegMenukeuzeToe(exit);
        DataSeeder.getInstance().voegMenuToe(uitgelogd);

        Menu caoMenu = new Menu("u bent ingelogd als Cao medewerker");
        Menukeuze registreer = new Menukeuze("registreer een vluchteling", new ActieRegistreer());
        Menukeuze werkDosierBij = new Menukeuze("werk dossier bij", new ActieWerkBij());
        Menukeuze vraagOpC = new Menukeuze("gemeente opvragen", new ActieVraagOpC());
        Menukeuze logout = new Menukeuze(9, "logout", true, new ActieLogout());
        caoMenu.voegMenukeuzeToe(werkDosierBij);
        caoMenu.voegMenukeuzeToe(registreer);
        caoMenu.voegMenukeuzeToe(vraagOpC);
        caoMenu.voegMenukeuzeToe(logout);
        DataSeeder.getInstance().voegMenuToe(caoMenu);


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
        DataSeeder.getInstance().voegMenuToe(beheerderMenu);


        Menu vluchtelingMenu = new Menu("u bent ingelogd als asielzoeker");
        Menukeuze gegevens = new Menukeuze("vraag gegevens op", new ActieGegevens());
        Menukeuze dossier = new Menukeuze("vraag dossier op", new ActieDosier());
        Menukeuze nieuwAdress = new Menukeuze("registreer nieuw adress", new ActieAdress());
        vluchtelingMenu.voegMenukeuzeToe(gegevens);
        vluchtelingMenu.voegMenukeuzeToe(dossier);
        vluchtelingMenu.voegMenukeuzeToe(nieuwAdress);
        vluchtelingMenu.voegMenukeuzeToe(logout);
        DataSeeder.getInstance().voegMenuToe(vluchtelingMenu);
    }
}
