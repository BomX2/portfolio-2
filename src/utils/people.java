package utils;

import model.Asielzoeker;
import model.Beheerder;
import model.CaoMedewerker;
import model.Gebruiker;

import java.util.ArrayList;

public class people {
    private final ArrayList<Gebruiker> gebruikers;

    public people() {
        gebruikers = new ArrayList<>();
    }
    public void initializeUsers(){

    }
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
}
