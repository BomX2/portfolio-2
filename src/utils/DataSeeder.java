package utils;

public class DataSeeder {
    private static DataSeeder instance = null;
    private Menus menus;
    private Landen landen;
    private Gebruikers gebruikers;
    private Gemeentes gemeentes;

    public Menus getMenus() {
        return menus;
    }
    public Gebruikers getGebruikers(){
        return gebruikers;
    }

    public Landen getLanden() {
        return landen;
    }

    public Gemeentes getGemeentes() {
        return gemeentes;
    }

    private void initialize() {
        menus.initializeMenus();
        gebruikers.initializeGebruikers();
        landen.initializeLanden();
        gemeentes.initializeGemeentes();
    }

    private DataSeeder() {
        this.menus = new Menus();
        this.landen = new Landen();
        this.gebruikers = new Gebruikers(this.landen);
        this.gemeentes = new Gemeentes();
        initialize();
    }

    public static DataSeeder getInstance() {
        if (instance == null) {
            instance = new DataSeeder();
        }
        return instance;
    }

    public boolean JaOfNee (String jaOfNee){
        if (jaOfNee.equalsIgnoreCase("ja")){
            return true;
        }
        return false;
    }

}
