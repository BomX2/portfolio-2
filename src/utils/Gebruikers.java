package utils;

import model.*;

import java.util.ArrayList;

public class Gebruikers {
    private Landen landen;
    private final ArrayList<Gebruiker> gebruikers;
    private Observable observable;
    private Gemeentes gemeentes;

    public Gebruikers(Landen landen, Observable observable, Gemeentes gemeentes) {
        this.landen = landen;
        gebruikers = new ArrayList<>();
        this.observable = observable;
        this.gemeentes = gemeentes;
    }
    public void initializeGebruikers(){
        Dossier dossierM = new Dossier("mohammad", landen.getLand("israel"), false);
        Asielzoeker asielzoeker = new Asielzoeker("amin","man",18, landen.getLand("israel"), dossierM,observable);
        voegAsielzoekerToe(asielzoeker);
        asielzoeker.setFamilielid(true);
        CaoMedewerker cao = new CaoMedewerker("jan");
        voegMedewerkerToe(cao);

        Beheerder beheerder = new Beheerder("tony");
        voegBeheerderToe(beheerder);

        AzcMedewerker azcMedewerker = new AzcMedewerker("kees",gemeentes.getGemeente("den haag").getAzc("6542 AB"));
        voegAzcMedewerkerToe(azcMedewerker);
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
    private void voegAzcMedewerkerToe (AzcMedewerker azcMedewerker){
        voegGebruikerToe(azcMedewerker);
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
}
